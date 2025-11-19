import java.util.ArrayList;
import java.util.HashSet;

public class CountDistinctIslands {

    int n, m;
    boolean[][] vis;

    public int countDistinctIslands(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        vis = new boolean[n][m];

        HashSet<ArrayList<String>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    ArrayList<String> shape = new ArrayList<>();
                    dfs(i, j, i, j, grid, shape);
                    set.add(shape);
                }
            }
        }

        return set.size();
    }

    private void dfs(int r, int c, int baseR, int baseC, int[][] grid, ArrayList<String> shape) {
        // boundary + visited + water
        if (r < 0 || c < 0 || r >= n || c >= m || grid[r][c] == 0 || vis[r][c]) {
            return;
        }

        vis[r][c] = true;

        // store relative position
        shape.add((r - baseR) + "," + (c - baseC));

        // explore 4 directions
        dfs(r + 1, c, baseR, baseC, grid, shape);
        dfs(r - 1, c, baseR, baseC, grid, shape);
        dfs(r, c + 1, baseR, baseC, grid, shape);
        dfs(r, c - 1, baseR, baseC, grid, shape);
    }

    public static void main(String[] args) {
        CountDistinctIslands obj = new CountDistinctIslands();

        int[][] grid = {
            {1, 1, 0, 0},
            {1, 0, 0, 1},
            {1, 1, 0, 1},
            {0, 0, 1, 1}
        };

        System.out.println(obj.countDistinctIslands(grid));  // Example test
    }
}
