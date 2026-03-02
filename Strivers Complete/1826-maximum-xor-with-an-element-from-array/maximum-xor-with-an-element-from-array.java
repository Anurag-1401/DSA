class Solution {
    static class Node{
        Node left, right;
    }

    Node root = new Node();

    public void insert(int num){
        Node node = root;
        for(int i=31; i>=0; i--){
            int bit = (num >> i) & 1;
            if (bit == 0) {
                if (node.left == null) node.left = new Node();
                node = node.left;
            } else {
                if (node.right == null) node.right = new Node();
                node = node.right;
            }
        }
    }

    public int getMax(int num){
        Node node = root;
        int max = 0;

        for(int i=31;i>=0;i--){
            int bit = (num >> i) & 1;

            if (bit == 0) {
                if (node.right != null) {
                    max |= (1 << i);
                    node = node.right;
                } else {
                    node = node.left;
                }
            } else {
                if (node.left != null) {
                    max |= (1 << i);
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
        }
        return max;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);

        int q = queries.length;
        int[][] offline = new int[q][3];

        for(int i=0;i<q;i++){
            offline[i][0] = queries[i][1];      //mi
            offline[i][1] = queries[i][0];      //xi
            offline[i][2] = i;                  //original index
        }

        Arrays.sort(offline, (a, b) -> a[0] - b[0]);
        int[] ans = new int[q];

        int idx = 0;
        for(int i=0;i<q;i++){
            int mi = offline[i][0];
            int xi = offline[i][1];
            int qi = offline[i][2];

            while(idx < nums.length && nums[idx] <= mi){
                insert(nums[idx]);
                idx++;
            }

            if(idx == 0){
                ans[qi] = -1;
            }else{
                ans[qi] = getMax(xi);
            }
        }
        return ans;
    }
}