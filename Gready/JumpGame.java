// https://leetcode.com/problems/jump-game/

import java.util.Scanner;

public class JumpGame {

    public static boolean canJump(int[] nums) {

        int maxIndex = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            // If current index is not reachable
            if (i > maxIndex) {
                return false;
            }

            // Update farthest reachable index
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }

        return true;
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(canJump(nums));

        sc.close();
    }
}
