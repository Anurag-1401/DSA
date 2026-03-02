class Solution {

    class Pair {
        TreeNode node;
        int hd;

        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public List<Integer> topView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            TreeNode node = curr.node;
            int hd = curr.hd;

            map.putIfAbsent(hd, node.data);

            if (node.left != null)
                q.offer(new Pair(node.left, hd - 1));

            if (node.right != null)
                q.offer(new Pair(node.right, hd + 1));
        }

        for (int val : map.values())
            ans.add(val);

        return ans;
    }
}
