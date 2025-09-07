import java.util.*;

// Node definition
class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

// Pair class to store node with its horizontal distance
class Pair {
    Node node;
    int hd;
    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class TopViewOfBinaryTree {

    // Function to return a list of nodes visible from the top view
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, Integer> mp = new TreeMap<>();

        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node node = current.node;
            int hd = current.hd;

            if (!mp.containsKey(hd)) {
                mp.put(hd, node.data);
            }

            if (node.left != null) {
                queue.offer(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, hd + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }

    // Testing
    public static void main(String[] args) {
        // Build a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);

        ArrayList<Integer> result = topView(root);
        System.out.println("Top View of Binary Tree: " + result);
    }
}
