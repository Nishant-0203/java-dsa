import java.util.ArrayList;

public class IsCyclicDirected {

    public boolean isCyclic(int v, int[][] adj) {

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            edges.add(new ArrayList<>());
        }

        // Build adjacency list
        for (int[] e : adj) {
            edges.get(e[0]).add(e[1]);
        }

        int[] vis = new int[v];
        int[] pathvis = new int[v];

        for (int i = 0; i < v; i++) {
            if (vis[i] == 0) {
                if (dfs(i, vis, edges, pathvis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> edges, int[] pathvis) {
        vis[node] = 1;
        pathvis[node] = 1;

        for (int neighbor : edges.get(node)) {
            if (vis[neighbor] == 0) {
                if (dfs(neighbor, vis, edges, pathvis)) {
                    return true;
                }
            } else if (pathvis[neighbor] == 1) {
                return true; // back-edge → cycle
            }
        }

        pathvis[node] = 0; // remove from current path
        return false;
    }

    public static void main(String[] args) {
        IsCyclicDirected obj = new IsCyclicDirected();

        int v = 4;
        int[][] adj = {
            {0, 1},
            {1, 2},
            {2, 3},
            {3, 1}  // creates a cycle
        };

        System.out.println(obj.isCyclic(v, adj)); // true
    }
}
