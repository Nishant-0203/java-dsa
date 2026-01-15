// https://www.geeksforgeeks.org/problems/count-occurences-of-a-word-in-a-2-d-array/1

import java.util.Scanner;

public class CountOccurencesOfAWordIn2DArray {

    // Count occurrences of word in the board
    public static int countWord(char[][] board, String word, int m, int n) {

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    count += dfs(board, word, m, n, i, j, 0);
                }
            }
        }

        return count;
    }

    // DFS helper with backtracking
    private static int dfs(char[][] board, String word, int m, int n,
                           int i, int j, int index) {

        if (i < 0 || i >= m || j < 0 || j >= n ||
            board[i][j] != word.charAt(index)) {
            return 0;
        }

        if (index == word.length() - 1) {
            return 1;
        }

        char temp = board[i][j];
        board[i][j] = '#'; // mark visited

        int res =
                dfs(board, word, m, n, i + 1, j, index + 1) +
                dfs(board, word, m, n, i - 1, j, index + 1) +
                dfs(board, word, m, n, i, j + 1, index + 1) +
                dfs(board, word, m, n, i, j - 1, index + 1);

        board[i][j] = temp; // backtrack

        return res;
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            String row = sc.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        String word = sc.next();

        System.out.println(countWord(board, word, m, n));

        sc.close();
    }
}
