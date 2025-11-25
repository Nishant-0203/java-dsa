import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleKahn {

    public boolean isCyclic(int v, int[][] edges) {

        int[] indegree = new int[v];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list (Directed graph)
        for (int[] e : edges) {
            int u = e[0];
            int w = e[1];
            adj.get(u).add(w);
        }

        // Compute indegree
        for (int i = 0; i < v; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        // Push all nodes with indegree 0 into queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        // If topological order size < vertices → cycle exists
        return topo.size() != v;
    }

    public static void main(String[] args) {
        DetectCycleKahn obj = new DetectCycleKahn();

        int v = 4;
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 3},
            {3, 1} // cycle
        };

        System.out.println(obj.isCyclic(v, edges)); // true → cycle present
    }
}
