//write a code to find total ways to add vowels in a string
import java.util.Scanner;
public class AddVowelsInString {

    static int totalWaysToAddVowels(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // One way to have an empty string

        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            if (isVowel(c)) {
                dp[i] = dp[i - 1] + dp[i - 2]; // Add vowel or skip
            } else {
                dp[i] = dp[i - 1]; // Just skip
            }
        }
        return dp[n];
    }

    static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(totalWaysToAddVowels(s));

        sc.close();
    }
}