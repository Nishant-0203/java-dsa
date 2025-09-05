import java.util.*;

public class TotalNQueens {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 4; // Example
        int totalSolutions = sol.totalNQueens(n);
        System.out.println("Total solutions for " + n + "-Queens: " + totalSolutions);
    }
}

class Solution {
    private void backtrack(char[][] board, int row, List<List<String>> res) {
        if (row == board.length) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                solution.add(new String(board[i]));
            }
            res.add(solution);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1, res);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        // check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    public int totalNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(board, 0, res);
        return res.size();
    }
}
