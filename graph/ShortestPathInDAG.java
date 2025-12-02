import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathInDAG {

    public int[] shortestPath(int V, int E, int[][] edges) {

        // Step 1: Build adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
        }

        // Step 2: Topological sort using DFS
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topoSort(i, adj, vis, st);
            }
        }

        // Step 3: Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // source = 0

        // Step 4: Relax edges in topological order
        while (!st.isEmpty()) {
            int node = st.pop();

            if (dist[node] != Integer.MAX_VALUE) {
                for (int[] edge : adj.get(node)) {
                    int next = edge[0];
                    int wt = edge[1];

                    if (dist[node] + wt < dist[next]) {
                        dist[next] = dist[node] + wt;
                    }
                }
            }
        }

        // Replace unreachable distances with -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    // Topo DFS
    private void topoSort(int node, List<List<int[]>> adj, boolean[] vis, Stack<Integer> st) {
        vis[node] = true;

        for (int[] edge : adj.get(node)) {
            int next = edge[0];
            if (!vis[next]) {
                topoSort(next, adj, vis, st);
            }
        }

        st.push(node);
    }

    // Optional: Test Main Method
    public static void main(String[] args) {
        ShortestPathInDAG obj = new ShortestPathInDAG();

        int V = 6, E = 7;
        int[][] edges = {
            {0, 1, 2},
            {0, 4, 1},
            {4, 5, 4},
            {4, 2, 2},
            {1, 2, 3},
            {2, 3, 6},
            {5, 3, 1}
        };

        int[] result = obj.shortestPath(V, E, edges);

        System.out.println("Shortest distances from node 0:");
        System.out.println(Arrays.toString(result));
    }
}
