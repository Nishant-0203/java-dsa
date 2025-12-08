import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Arrays;

public class ShortestPathDAG {

    public int[] shortestPath(int v, int e, int[][] edges) {

        // Build adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        // Topological sort
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                topo(i, adj, vis, st);
            }
        }

        // Distance array
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;  // source = 0

        // Relax edges in topo order
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

        // Replace unreachable with -1
        for (int i = 0; i < v; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    // DFS for topological sort
    public void topo(int node, List<List<int[]>> adj, boolean[] vis, Stack<Integer> st) {
        vis[node] = true;

        for (int[] edge : adj.get(node)) {
            int next = edge[0];
            if (!vis[next]) {
                topo(next, adj, vis, st);
            }
        }

        st.push(node);
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {
        ShortestPathDAG obj = new ShortestPathDAG();

        int v = 6;
        int e = 7;

        int[][] edges = {
            {0, 1, 2},
            {0, 4, 1},
            {4, 5, 4},
            {4, 2, 2},
            {1, 2, 3},
            {2, 3, 6},
            {5, 3, 1}
        };

        int[] result = obj.shortestPath(v, e, edges);

        System.out.println("Shortest distances from node 0:");
        System.out.println(Arrays.toString(result));
    }
}
