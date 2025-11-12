import java.util.*;

public class Bfs {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfsList = new ArrayList<>();
        int V = adj.size();
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        // Start BFS from node 0
        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            bfsList.add(node);

            // Visit all adjacent nodes of 'node'
            for (int it : adj.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }

        return bfsList;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Graph: [[2,3,1],[0],[0,4],[0],[2]]
        int V = 5;
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(2).add(0);
        adj.get(2).add(4);
        adj.get(3).add(0);
        adj.get(4).add(2);

        Bfs sol = new Bfs();
        System.out.println("BFS Traversal: " + sol.bfs(adj));
    }
}
