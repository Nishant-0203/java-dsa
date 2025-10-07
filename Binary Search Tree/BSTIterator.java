// File: BSTIterator.java
import java.util.*;

public class BSTIterator {

    // Definition for a binary tree node.
    static class TreeNode {
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

    private Stack<TreeNode> st = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    public int next() {
        TreeNode temp = st.pop();
        pushAll(temp.right);
        return temp.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void pushAll(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left; // keep going left
        }
    }

    // Main method for testing in VS Code
    public static void main(String[] args) {
        /*
         Example tree:
                 7
                / \
               3   15
                  /  \
                 9    20
        */
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15, new TreeNode(9), new TreeNode(20));

        BSTIterator iterator = new BSTIterator(root);

        System.out.println(iterator.next());    // 3
        System.out.println(iterator.next());    // 7
        System.out.println(iterator.hasNext()); // true
        System.out.println(iterator.next());    // 9
        System.out.println(iterator.hasNext()); // true
        System.out.println(iterator.next());    // 15
        System.out.println(iterator.next());    // 20
        System.out.println(iterator.hasNext()); // false
    }
}
