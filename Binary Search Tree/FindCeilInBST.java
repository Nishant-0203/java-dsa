// File: FindCeilInBST.java

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class FindCeilInBST {

    public int findCeil(Node root, int key) {
        int ceil = -1;
        while (root != null) {
            if (root.data == key) {
                ceil = root.data;
                return ceil;
            }
            if (root.data < key) {
                root = root.right;
            } else {
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }

    // 🔹 main method for quick testing
    public static void main(String[] args) {
        // Build a sample BST
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.right.left = new Node(10);
        root.right.right = new Node(14);

        FindCeilInBST solution = new FindCeilInBST();

        int key = 5;
        int ceilValue = solution.findCeil(root, key);
        System.out.println("Ceil of " + key + " is: " + ceilValue);

        key = 11;
        ceilValue = solution.findCeil(root, key);
        System.out.println("Ceil of " + key + " is: " + ceilValue);

        key = 15;
        ceilValue = solution.findCeil(root, key);
        System.out.println("Ceil of " + key + " is: " + ceilValue);
    }
}
