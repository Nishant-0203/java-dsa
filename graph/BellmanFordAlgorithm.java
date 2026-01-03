// https://www.geeksforgeeks.org/problems/bellman-ford-algorithm-1663450930/1

import java.util.Scanner;

public class BellmanFordAlgorithm {

    public static int[] bellmanFord(int V, int[][] edges, int S) {

        int INF = (int) 1e8;
        int[] dist = new int[V];

        // Initialize distances
        for (int i = 0; i < V; i++) {
            dist[i] = INF;
        }
        dist[S] = 0;

        // Relax edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (int[] it : edges) {
                int u = it[0];
                int v = it[1];
                int w = it[2];

                if (dist[u] != INF && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // Check for negative weight cycle
        for (int[] it : edges) {
            int u = it[0];
            int v = it[1];
            int w = it[2];

            if (dist[u] != INF && dist[u] + w < dist[v]) {
                return new int[]{-1};
            }
        }

        return dist;
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] edges = new int[E][3];
        for (int i = 0; i < E; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        int S = sc.nextInt();

        int[] result = bellmanFord(V, edges, S);

        if (result.length == 1 && result[0] == -1) {
            System.out.println(-1);
        } else {
            for (int d : result) {
                System.out.print(d + " ");
            }
        }

        sc.close();
    }
}
