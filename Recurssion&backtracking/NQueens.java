import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 4; // Example for 4-queens
        List<List<String>> result = sol.solveNQueens(n);

        System.out.println("All possible solutions for " + n + "-Queens:");
        for (List<String> board : result) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}

class Solution {
    public Boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    public void backtrack(int row, char[][] board, List<List<String>> res) {
        if (row == board.length) {
            List<String> sol = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                sol.add(new String(board[i]));
            }
            res.add(sol);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(row + 1, board, res);
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(0, board, res);
        return res;
    }
}
