import java.util.*;

// Node class for binary tree
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

// Pair class for BFS (node + horizontal distance)
class Pair {
    Node node;
    int hd;
    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class BottomViewOfBinaryTree {

    // Function to return a list of nodes visible from the bottom view
    static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, Integer> mp = new TreeMap<>();

        // Start BFS
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.remove();
            Node node = current.node;
            int hd = current.hd;

            // For bottom view, always overwrite
            mp.put(hd, node.data);

            if (node.left != null) {
                queue.offer(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, hd + 1));
            }
        }

        // Collect result in order of horizontal distances
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            list.add(entry.getValue());
        }

        return list;
    }

    // Testing
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        ArrayList<Integer> result = bottomView(root);
        System.out.println("Bottom View: " + result);
    }
}
