public class NumIslands {

    public void dfs(int r, int c, boolean[][] vis, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (r < 0 || c < 0 || r >= n || c >= m || grid[r][c] == '0' || vis[r][c]) {
            return;
        }

        vis[r][c] = true;

        dfs(r - 1, c, vis, grid);
        dfs(r + 1, c, vis, grid);
        dfs(r, c - 1, vis, grid);
        dfs(r, c + 1, vis, grid);
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    dfs(i, j, vis, grid);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        NumIslands obj = new NumIslands();

        char[][] grid = {
            {'1','1','0','0'},
            {'1','0','0','1'},
            {'0','0','1','1'}
        };

        System.out.println(obj.numIslands(grid)); // Example test
    }
}
