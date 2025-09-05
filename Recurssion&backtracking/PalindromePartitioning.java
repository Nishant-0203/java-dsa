import java.util.*;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "aab";
        List<List<String>> result = sol.partition(s);

        System.out.println("Palindrome partitions of \"" + s + "\":");
        for (List<String> part : result) {
            System.out.println(part);
        }
    }
}

class Solution {
    public void solve(List<List<String>> res, List<String> pres, String s, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(pres));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (ispalindrome(s, index, i)) {
                pres.add(s.substring(index, i + 1));
                solve(res, pres, s, i + 1);
                pres.remove(pres.size() - 1);
            }
        }
    }

    public boolean ispalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> pres = new ArrayList<>();
        solve(res, pres, s, 0);
        return res;
    }
}
