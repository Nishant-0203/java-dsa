public class FindCircleNum {

    public void dfs(int node, int[] vis, int[][] isConnected, int v) {
        vis[node] = 1;

        for (int i = 0; i < v; i++) {
            if (isConnected[node][i] == 1 && vis[i] == 0) {
                dfs(i, vis, isConnected, v);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        int count = 0;
        int[] vis = new int[v];

        for (int i = 0; i < v; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, isConnected, v);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FindCircleNum obj = new FindCircleNum();

        int[][] graph = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };

        System.out.println(obj.findCircleNum(graph)); // Example test
    }
}
