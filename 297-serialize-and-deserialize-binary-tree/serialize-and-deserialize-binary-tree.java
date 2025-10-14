/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// public class Codec {

//     // Encodes a tree to a single string.
//     public String serialize(TreeNode root) {
//         if(root == null) return "null";
//         return root.val + "," + serialize(root.left) + "," + serialize(root.right); 
//     }

//     // Decodes your encoded data to tree.
//     public TreeNode deserialize(String data) {
//         Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
//         return build(nodes); 
//     }
//     private TreeNode build(Queue<String> nodes){
//         String val = nodes.poll();
//         if(val.equals("null")) return null;

//         TreeNode tree = new TreeNode(Integer.parseInt(val));
//         tree.left = build(nodes);
//         tree.right = build(nodes);
        
//         return tree;
//     }
// }


public class Codec {
    class IdNode {
        int val;
        int left_id;
        int right_id;
    }
    static TreeNode temp = null;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        temp = root;
        // ArrayList<IdNode> nodeList = new ArrayList();
        return new String();
    }
    
    private int toNodeList(TreeNode node, ArrayList<IdNode> list) {
        if (node == null) {
            return 0;
        }
        
        IdNode idNode = new IdNode();
        int node_id = list.size();
        list.add(idNode);
        idNode.val = node.val;
        idNode.left_id = toNodeList(node.left, list);
        idNode.right_id = toNodeList(node.right, list);
            
        return node_id;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return temp;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));