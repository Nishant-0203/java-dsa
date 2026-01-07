// https://leetcode.com/problems/valid-parenthesis-string/

import java.util.Scanner;

public class ValidParenthesisString {

    public static boolean checkValidString(String s) {

        int minOpen = 0;
        int maxOpen = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                minOpen++;
                maxOpen++;
            } else if (ch == ')') {
                minOpen--;
                maxOpen--;
            } else { // '*'
                minOpen--;   // treat '*' as ')'
                maxOpen++;   // or treat '*' as '('
            }

            // Too many closing brackets
            if (maxOpen < 0) {
                return false;
            }

            // Clamp minOpen to 0
            if (minOpen < 0) {
                minOpen = 0;
            }
        }

        return minOpen == 0;
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------     
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(checkValidString(s));

        sc.close();
    }
}
