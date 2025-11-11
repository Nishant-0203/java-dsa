import java.io.*;
import java.util.*;

class DirectedStoring {
    public static void main (String[] args) {

        int n = 3, m = 3;   // n = nodes, m = edges
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // create n+1 lists (1-based indexing)
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        // directed edges
        // 1 → 2
        adj.get(1).add(2);

        // 2 → 3
        adj.get(2).add(3);

        // 1 → 3
        adj.get(1).add(3);

        // print adjacency list
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
