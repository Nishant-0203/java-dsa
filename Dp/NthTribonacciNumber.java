// https://leetcode.com/problems/n-th-tribonacci-number/

import java.util.Scanner;

public class NthTribonacciNumber {

    public static int tribonacci(int n) {

        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int a = 0; // T0
        int b = 1; // T1
        int c = 1; // T2

        for (int i = 3; i <= n; i++) {
            int next = a + b + c;
            a = b;
            b = c;
            c = next;
        }

        return c;
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(tribonacci(n));

        sc.close();
    }
}
