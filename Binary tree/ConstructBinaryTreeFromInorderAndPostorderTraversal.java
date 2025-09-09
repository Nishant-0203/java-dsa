import java.util.HashMap;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private int idx;

    public TreeNode result(int[] post, int[] in, int start, int end, HashMap<Integer, Integer> mp) {
        if (start > end || idx < 0) {
            return null;
        }

        // Pick the current root from postorder
        int rootVal = post[idx--];
        TreeNode root = new TreeNode(rootVal);

        // Find the position in inorder
        int pos = mp.get(rootVal);

        // Build right subtree first, then left subtree
        root.right = result(post, in, pos + 1, end, mp);
        root.left = result(post, in, start, pos - 1, mp);

        return root;
    }

    public TreeNode buildTree(int[] in, int[] post) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            mp.put(in[i], i);
        }
        idx = post.length - 1; // Start from the last element of postorder
        return result(post, in, 0, in.length - 1, mp);
    }

    // Main method for testing in VS Code
    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal obj =
                new ConstructBinaryTreeFromInorderAndPostorderTraversal();

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = obj.buildTree(inorder, postorder);
        System.out.println("Tree constructed successfully. Root value: " + root.val);
    }
}
