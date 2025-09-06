import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] candidates = {2, 3, 6, 7}; // Example input
        int target = 7;

        List<List<Integer>> result = sol.combinationSum(candidates, target);

        System.out.println("Combination sums for target " + target + ":");
        for (List<Integer> comb : result) {
            System.out.println(comb);
        }
    }
}

class Solution {
    public void check(int index, int target, int[] candidates, List<List<Integer>> list, List<Integer> list1) {
        // Base case: if we have checked all elements
        if (index == candidates.length) {
            if (target == 0) {
                list.add(new ArrayList<>(list1));
            }
            return;
        }

        if (candidates[index] <= target) {
            list1.add(candidates[index]);
            check(index, target - candidates[index], candidates, list, list1);
            list1.remove(list1.size() - 1);
        }

        check(index + 1, target, candidates, list, list1);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        check(0, target, candidates, list, new ArrayList<>());
        return list;
    }
}
