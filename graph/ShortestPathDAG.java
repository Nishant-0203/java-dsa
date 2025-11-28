import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestPathDAG {

    public int[] shortestPath(int V, int E, int[][] edges) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adj.get(u).add(new int[]{v, w});
        }

        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoDFS(i, visited, st, adj);
            }
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while (!st.isEmpty()) {
            int u = st.pop();

            if (dist[u] != Integer.MAX_VALUE) {
                for (int[] edge : adj.get(u)) {
                    int v = edge[0];
                    int w = edge[1];

                    if (dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                    }
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }

        return dist;
    }

    private void topoDFS(int node, boolean[] vis, Stack<Integer> st, ArrayList<ArrayList<int[]>> adj) {
        vis[node] = true;

        for (int[] edge : adj.get(node)) {
            int neigh = edge[0];
            if (!vis[neigh]) {
                topoDFS(neigh, vis, st, adj);
            }
        }

        st.push(node);
    }

    // ---------------------------
    // MAIN METHOD FOR EXECUTION
    // ---------------------------
    public static void main(String[] args) {
        ShortestPathDAG obj = new ShortestPathDAG();

        int V = 6;
        int E = 7;

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
        for (int dist : result) {
            System.out.print(dist + " ");
        }
    }
}
