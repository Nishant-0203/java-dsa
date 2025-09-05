import java.util.*;

public class PermutationsII {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 1, 2}; // Example input

        List<List<Integer>> result = sol.permute(nums);

        System.out.println("Unique permutations of " + Arrays.toString(nums) + ":");
        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }
}

class Solution {
    private Set<List<Integer>> set = new HashSet<>();

    public void solve(int[] s, int index) {
        if (index >= s.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : s) {
                permutation.add(num);
            }
            set.add(permutation); // add full permutation
            return;
        }

        for (int j = index; j < s.length; j++) {
            int temp = s[j];
            s[j] = s[index];
            s[index] = temp;

            solve(s, index + 1);

            // backtrack (undo the swap)
            temp = s[j];
            s[j] = s[index];
            s[index] = temp;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        set.clear();
        solve(nums, 0);
        return new ArrayList<>(set);
    }
}
