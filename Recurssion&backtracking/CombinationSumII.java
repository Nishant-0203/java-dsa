import java.util.*;

public class CombinationSumII {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5}; // Example input
        int target = 8;

        List<List<Integer>> result = sol.combinationSum2(candidates, target);

        System.out.println("Combination sums (each number once) for target " + target + ":");
        for (List<Integer> comb : result) {
            System.out.println(comb);
        }
    }
}

class Solution {
    public void check(int[] candidates, int target, int index, List<List<Integer>> list, List<Integer> list1) {
        if (target == 0) {
            list.add(new ArrayList<>(list1));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            list1.add(candidates[i]);
            check(candidates, target - candidates[i], i + 1, list, list1);
            list1.remove(list1.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        check(candidates, target, 0, list, new ArrayList<>());
        return list;
    }
}
