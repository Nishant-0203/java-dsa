import java.util.ArrayList;

public class DetectCycleInGraph {

    public boolean dfs(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> list) {
        vis[node] = true;

        for (int it : list.get(node)) {
            if (!vis[it]) {
                if (dfs(it, node, vis, list)) {
                    return true;
                }
            }
            // If visited and not parent → cycle
            else if (it != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }

        // Build adjacency list
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            list.get(u).add(v);
            list.get(v).add(u);  // Undirected graph
        }

        boolean[] vis = new boolean[V];

        // DFS on every component
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, -1, vis, list)) {
                    return true; // Found cycle
                }
            }
        }

        return false; // No cycle found
    }

    public static void main(String[] args) {
        DetectCycleInGraph obj = new DetectCycleInGraph();

        int V = 5;
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 0},
            {3, 4}
        };

        System.out.println(obj.isCycle(V, edges)); // true → cycle exists
    }
}
