/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {

    public class NodeState{
        TreeNode node;
        int state;

        NodeState(TreeNode node,int state){
            this.node = node;
            this.state = state;
        }
    }

    List<List<Integer>> treeTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            ans.add(in);
            ans.add(pre);
            ans.add(post);

            return ans;
        }

        Stack<NodeState> st = new Stack<>();
        st.push(new NodeState(root,1));

        while(!st.isEmpty()){
            NodeState curr = st.pop();

            if(curr.state == 1){
                pre.add(curr.node.data);
                curr.state++;
                st.push(curr);
            
                if(curr.node.left != null) st.push(new NodeState(curr.node.left,1));

            } else if(curr.state == 2){
                in.add(curr.node.data);
                curr.state++;
                st.push(curr);
            
                if(curr.node.right != null) st.push(new NodeState(curr.node.right,1));
            } else {
                post.add(curr.node.data);
            }
        }

        ans.add(in);
        ans.add(pre);
        ans.add(post);

        return ans;
    }
}
