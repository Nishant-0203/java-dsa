// https://leetcode.com/problems/generate-parentheses/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParentheses {

    private static ArrayList<String> ans;

    public static void backtrack(int n, int open, int close, String current) {

        // Base case: valid sequence of length 2*n
        if (current.length() == 2 * n) {
            ans.add(current);
            return;
        }

        // Add '(' if we still can
        if (open < n) {
            backtrack(n, open + 1, close, current + '(');
        }

        // Add ')' if it won't break validity
        if (close < open) {
            backtrack(n, open, close + 1, current + ')');
        }
    }

    public static List<String> generateParenthesis(int n) {

        ans = new ArrayList<>();
        backtrack(n, 0, 0, "");
        return ans;
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<String> result = generateParenthesis(n);

        for (String s : result) {
            System.out.println(s);
        }

        sc.close();
    }
}
