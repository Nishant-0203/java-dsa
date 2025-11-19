import java.util.Queue;
import java.util.LinkedList;

public class IsBipartite {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n]; // 0 = uncolored, 1 = red, -1 = blue

        for (int i = 0; i < n; i++) {
            if (color[i] != 0)
                continue;

            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            color[i] = 1;

            while (!q.isEmpty()) {
                int node = q.poll();

                for (int adj : graph[node]) {
                    if (color[adj] == 0) {
                        color[adj] = -color[node];
                        q.add(adj);
                    } else if (color[adj] == color[node]) {
                        return false; // Same color → not bipartite
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsBipartite obj = new IsBipartite();

        int[][] graph = {
            {1, 3},
            {0, 2},
            {1, 3},
            {0, 2}
        };

        System.out.println(obj.isBipartite(graph)); // true
    }
}
