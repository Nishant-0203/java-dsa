public class FloodFill {

    public void dfs(int r, int c, int[][] image, int num, int color) {
        int n = image.length;
        int m = image[0].length;

        if (r < 0 || c < 0 || r >= n || c >= m || image[r][c] != num) {
            return;
        }

        image[r][c] = color;

        dfs(r - 1, c, image, num, color);
        dfs(r + 1, c, image, num, color);
        dfs(r, c - 1, image, num, color);
        dfs(r, c + 1, image, num, color);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int num = image[sr][sc];

        if (num == color) {
            return image;
        }

        dfs(sr, sc, image, num, color);
        return image;
    }

    public static void main(String[] args) {
        FloodFill obj = new FloodFill();

        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        int[][] result = obj.floodFill(image, 1, 1, 2);

        // Print result
        for (int[] row : result) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
