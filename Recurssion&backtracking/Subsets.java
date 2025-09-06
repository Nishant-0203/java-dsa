import java.util.*;

public class Subsets {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3}; // Example input

        List<List<Integer>> result = sol.subsets(nums);

        System.out.println("All subsets of " + Arrays.toString(nums) + ":");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}

class Solution {
    private ArrayList<List<Integer>> list = new ArrayList<>();

    public void solve(int[] nums, List<Integer> list1, int index) {
        if (index >= nums.length) {
            list.add(new ArrayList<>(list1));
            return;
        }

        // Exclude current element
        solve(nums, list1, index + 1);

        // Include current element
        int element = nums[index];
        list1.add(element);
        solve(nums, list1, index + 1);
        list1.remove(list1.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> list1 = new ArrayList<>();
        solve(nums, list1, 0);
        return list;
    }
}
