import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null";

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null,");
                continue;
            }
            sb.append(node.val).append(",");
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.equals("null")) {
            return null;
        }

        String[] node = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(node[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < node.length) {
            TreeNode parent = queue.poll();
            
            if (!node[i].equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(node[i]));
                parent.left = leftNode;
                queue.offer(leftNode);
            }
            i++;

            if (i < node.length && !node[i].equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(node[i]));
                parent.right = rightNode;
                queue.offer(rightNode);
            }
            i++;
        }
        return root;
    }

    // Main method for testing in VS Code
    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree codec = new SerializeAndDeserializeBinaryTree();

        // Constructing a sample tree:
        //       1
        //      / \
        //     2   3
        //        / \
        //       4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Serialize
        String serialized = codec.serialize(root);
        System.out.println("Serialized: " + serialized);

        // Deserialize
        TreeNode deserialized = codec.deserialize(serialized);
        System.out.println("Deserialized root value: " + deserialized.val);
    }
}
