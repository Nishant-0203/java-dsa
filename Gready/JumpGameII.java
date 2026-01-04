// https://leetcode.com/problems/jump-game-ii/

import java.util.Scanner;

public class JumpGameII {

    public static int jump(int[] nums) {

        int jumps = 0;
        int l = 0;
        int r = 0;

        while (r < nums.length - 1) {

            int farthest = 0;

            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            l = r + 1;
            r = farthest;
            jumps++;
        }

        return jumps;
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

        System.out.println(jump(nums));

        sc.close();
    }
}
