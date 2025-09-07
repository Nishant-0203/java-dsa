import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

public class BoundaryTraversalOfBinaryTree {

    boolean leaf(Node node) {
        return (node.left == null && node.right == null);
    }

    void leftside(Node node, ArrayList<Integer> list) {
        Node curr = node.left;
        while (curr != null) {
            if (!leaf(curr)) {
                list.add(curr.data);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    void inorder(Node node, ArrayList<Integer> list) {
        if (leaf(node)) {
            list.add(node.data);
            return;
        }
        if (node.left != null) {
            inorder(node.left, list);
        }
        if (node.right != null) {
            inorder(node.right, list);
        }
    }

    void rightside(Node node, ArrayList<Integer> list) {
        ArrayList<Integer> temp = new ArrayList<>();
        Node curr = node.right;
        while (curr != null) {
            if (!leaf(curr)) {
                temp.add(curr.data);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            list.add(temp.get(i));
        }
    }

    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> list = new ArrayList<>();
        if (!leaf(node)) {
            list.add(node.data);
        }
        leftside(node, list);
        inorder(node, list);
        rightside(node, list);
        return list;
    }

    // Testing
    public static void main(String[] args) {
        BoundaryTraversalOfBinaryTree sol = new BoundaryTraversalOfBinaryTree();

        // Constructing the binary tree
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        root.right = new Node(22);
        root.right.right = new Node(25);

        ArrayList<Integer> result = sol.boundaryTraversal(root);
        System.out.println("Boundary Traversal: " + result);
    }
}
