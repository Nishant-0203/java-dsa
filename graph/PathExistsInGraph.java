// https://www.geeksforgeeks.org/problems/find-if-path-exists-in-graph/1

import java.util.*;

public class PathExistsInGraph {

    public static boolean dfs(List<List<Integer>> graph, int src, int dest, boolean[] visited) {

        if (src == dest) {
            return true;
        }

        visited[src] = true;

        for (int neigh : graph.get(src)) {
            if (!visited[neigh]) {
                if (dfs(graph, neigh, dest, visited)) {
                    return true; // early stop
                }
            }
        }

        return false;
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt(); // vertices
        int e = sc.nextInt(); // edges

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            graph.get(u).add(w); // directed edge
        }

        int src = sc.nextInt();
        int dest = sc.nextInt();

        boolean[] visited = new boolean[v];

        if (dfs(graph, src, dest, visited)) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }

        sc.close();
    }
}
