public class OrangesRotting {

    public void dfs(int[][] grid, int i, int j, int n, int m, int min) {

        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0 ||
            (grid[i][j] > 1 && grid[i][j] < min)) {
            return;
        }

        grid[i][j] = min;

        dfs(grid, i - 1, j, n, m, min + 1);
        dfs(grid, i + 1, j, n, m, min + 1);
        dfs(grid, i, j - 1, n, m, min + 1);
        dfs(grid, i, j + 1, n, m, min + 1);
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Start DFS from all rotten oranges (value 2)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, i, j, n, m, 2);
                }
            }
        }

        int minutes = 2;

        // Check if any fresh orange remains or find max time
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) {
                    return -1; // Fresh orange left
                }
                minutes = Math.max(minutes, cell);
            }
        }

        return minutes - 2; // Subtract initial value (2)
    }

    public static void main(String[] args) {
        OrangesRotting obj = new OrangesRotting();

        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        System.out.println(obj.orangesRotting(grid)); // Example test
    }
}
