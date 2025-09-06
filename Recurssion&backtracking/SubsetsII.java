import java.util.*;

public class SubsetsII {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 2}; // Example input

        List<List<Integer>> result = sol.subsetsWithDup(nums);

        System.out.println("All subsets with duplicates handled for " + Arrays.toString(nums) + ":");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}

class Solution {
    public void check(int index, int[] nums, List<List<Integer>> list, List<Integer> list1) {
        list.add(new ArrayList<>(list1));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1])
                continue;
            list1.add(nums[i]);
            check(i + 1, nums, list, list1);
            list1.remove(list1.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        check(0, nums, list, new ArrayList<>());
        return list;
    }
}
