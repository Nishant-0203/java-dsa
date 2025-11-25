import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopoSort {

    public ArrayList<Integer> topoSort(int v, int[][] edges) {

        int[] indegree = new int[v];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list
        for (int[] e : edges) {
            int u = e[0];
            int w = e[1];
            adj.get(u).add(w); // directed edge
        }

        // Compute indegree of each node
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

        return topo;
    }

    public static void main(String[] args) {
        TopoSort obj = new TopoSort();

        int v = 6;
        int[][] edges = {
            {5, 0},
            {5, 2},
            {4, 0},
            {4, 1},
            {2, 3},
            {3, 1}
        };

        System.out.println(obj.topoSort(v, edges)); 
        // Example Output: [5, 4, 2, 3, 1, 0]
    }
}
