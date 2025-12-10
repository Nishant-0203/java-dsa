import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Arrays;

public class DijkstraShortestPath {

    public int[] dijkstra(int V, int[][] edges, int src) {

        // Build adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w}); // undirected graph
        }

        // Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Min-heap: stores {distance, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int currDist = top[0];
            int node = top[1];

            // Skip stale entries
            if (currDist > dist[node]) continue;

            for (int[] it : adj.get(node)) {
                int adjNode = it[0];
                int weight = it[1];

                if (currDist + weight < dist[adjNode]) {
                    dist[adjNode] = currDist + weight;
                    pq.add(new int[]{dist[adjNode], adjNode});
                }
            }
        }

        return dist;
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        DijkstraShortestPath obj = new DijkstraShortestPath();

        int V = 5;
        int[][] edges = {
            {0, 1, 2},
            {0, 2, 4},
            {1, 2, 1},
            {1, 3, 7},
            {2, 4, 3},
            {3, 4, 1}
        };

        int src = 0;

        int[] result = obj.dijkstra(V, edges, src);

        System.out.println("Shortest distances from node " + src + ":");
        System.out.println(Arrays.toString(result));
    }
}
