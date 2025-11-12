import java.util.*;

public class Dfs {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfsList = new ArrayList<>();
        int V = adj.size();
        boolean[] vis = new boolean[V];

        dfsHelper(0, adj, vis, dfsList);
        return dfsList;
    }

    private void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> dfsList) {
        vis[node] = true;
        dfsList.add(node);

        for (int it : adj.get(node)) {
            if (!vis[it]) dfsHelper(it, adj, vis, dfsList);
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
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

        Dfs sol = new Dfs();
        System.out.println("DFS Traversal: " + sol.dfs(adj));
    }
}
