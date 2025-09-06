import java.util.*;

public class LetterCombinations {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String digits = "23"; // Example input

        List<String> result = sol.letterCombinations(digits);

        System.out.println("Letter combinations for digits \"" + digits + "\":");
        for (String comb : result) {
            System.out.println(comb);
        }
    }
}

class Solution {
    private ArrayList<String> ans = new ArrayList<>();

    public void solve(String digits, String output, int index, String[] map) {
        if (index >= digits.length()) {
            ans.add(output);
            return;
        }

        int number = digits.charAt(index) - '0';
        String word = map[number];

        for (int i = 0; i < word.length(); i++) {
            solve(digits, output + word.charAt(i), index + 1, map);
        }
    }

    public List<String> letterCombinations(String digits) {
        ans.clear(); // clear old results
        if (digits == null || digits.length() == 0)
            return ans;

        String output = "";
        int index = 0;
        String[] map = { " ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        solve(digits, output, index, map);
        return ans;
    }
}
