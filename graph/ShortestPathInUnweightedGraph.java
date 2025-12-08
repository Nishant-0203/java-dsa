import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class ShortestPathInUnweightedGraph {

    public int[] shortestPath(int V, int[][] edges, int src) {

        // Step 1: Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int w = e[1];
            adj.get(u).add(w);
            adj.get(w).add(u); // undirected graph
        }

        // Step 2: Distance array
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        // Step 3: BFS
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neigh : adj.get(node)) {
                if (dist[node] + 1 < dist[neigh]) {
                    dist[neigh] = dist[node] + 1;
                    q.add(neigh);
                }
            }
        }

        // Step 4: Mark unreachable nodes as -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        ShortestPathInUnweightedGraph obj = new ShortestPathInUnweightedGraph();

        int V = 7;
        int[][] edges = {
            {0, 1},
            {0, 3},
            {1, 2},
            {3, 4},
            {4, 5},
            {5, 6}
        };

        int src = 0;

        int[] result = obj.shortestPath(V, edges, src);

        System.out.println("Shortest path distances from node " + src + ":");
        System.out.println(Arrays.toString(result));
    }
}
