// File: FloorInBST.java

// ✅ Node definition
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

// ✅ Solution class
class Solution {
    public static int floor(Node root, int x) {
        int floor = -1;
        while (root != null) {
            if (root.data == x) {
                return root.data; // exact match
            }
            if (root.data < x) {
                floor = root.data; // candidate floor
                root = root.right; // search for bigger floor
            } else {
                root = root.left; // search left
            }
        }
        return floor;
    }
}

// ✅ Main class for testing
    public class FloorInBST {
    public static void main(String[] args) {
        // Build BST
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right.left = new Node(12);
        root.right.right = new Node(20);

        // Test cases
        System.out.println("Floor of 6 -> " + Solution.floor(root, 6));
        System.out.println("Floor of 14 -> " + Solution.floor(root, 14));
        System.out.println("Floor of 20 -> " + Solution.floor(root, 20));
        System.out.println("Floor of 1 -> " + Solution.floor(root, 1));
    }
}