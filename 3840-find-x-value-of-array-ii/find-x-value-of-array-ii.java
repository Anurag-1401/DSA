class Solution {
    static class Node {
        int prod;
        int[] cnt;

        Node(int k) {
            cnt = new int[k];
            prod = 1;
        }
    }

    private int N;
    private int K;
    private Node[] tree;

    private Node merge(Node left, Node right) {
        Node res = new Node(K);
        res.prod = (left.prod * right.prod) % K;

        // Copy left counts
        for (int r = 0; r < K; r++) {
            res.cnt[r] = left.cnt[r];
        }

        // Add counts from right offset by left.prod
        for (int r = 0; r < K; r++) {
            int newRem = (left.prod * r) % K;
            res.cnt[newRem] += right.cnt[r];
        }

        return res;
    }

    private void build(int node, int start, int end, int[] nums) {
        if (start == end) {
            int rem = nums[start] % K;
            tree[node].prod = rem;
            tree[node].cnt[rem] = 1;
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * node, start, mid, nums);
        build(2 * node + 1, mid + 1, end, nums);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            int rem = val % K;
            tree[node] = new Node(K);
            tree[node].prod = rem;
            tree[node].cnt[rem] = 1;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private Node query(int node, int start, int end, int l, int r) {
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        if (r <= mid) {
            return query(2 * node, start, mid, l, r);
        }
        if (l > mid) {
            return query(2 * node + 1, mid + 1, end, l, r);
        }

        Node leftRes = query(2 * node, start, mid, l, r);
        Node rightRes = query(2 * node + 1, mid + 1, end, l, r);
        return merge(leftRes, rightRes);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.N = nums.length;
        this.K = k;
        this.tree = new Node[4 * N];

        for (int i = 0; i < 4 * N; i++) {
            tree[i] = new Node(K);
        }

        build(1, 0, N - 1, nums);

        int[] ans = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int idx = queries[q][0];
            int val = queries[q][1];
            int start = queries[q][2];
            int targetX = queries[q][3];

            // 1. Update element
            update(1, 0, N - 1, idx, val);

            // 2. Query range [start, N - 1]
            Node resNode = query(1, 0, N - 1, start, N - 1);

            // 3. Store result
            ans[q] = resNode.cnt[targetX];
        }

        return ans;
    }
}