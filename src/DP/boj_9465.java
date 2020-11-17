package DP;

import java.util.*;

// dynamic programming
// I solved!!!!!!!!! no reference!!!!!!!!

public class boj_9465 {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i=0;i<T;i++) {
            int n = scanner.nextInt();
            int arr[][] = new int [2][n];
            int dp[][] = new int [2][n];
            for (int row = 0; row < 2; row ++) {
                for (int col = 0; col < n; col ++) {
                    arr[row][col] = scanner.nextInt();
                }
            }
            // initialize
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            dp[0][1] = dp[1][0] + arr[0][1];
            dp[1][1] = dp[0][0] + arr[1][1];

            if (n == 1 || n == 2) {
                int result = dp[0][n-1] > dp [1][n-1] ? dp[0][n-1] : dp [1][n-1];
                System.out.println(result);
                continue;
            }

            for (int col = 2; col < n; col ++) {
                int a = arr[0][col] + dp[1][col-1];
                int b = arr[0][col] + dp[1][col-2];
                dp[0][col] = a > b ? a : b;
                a = arr[1][col] + dp[0][col-1];
                b = arr[1][col] + dp[0][col-2];
                dp[1][col] = a > b ? a : b;
            }
            int result = dp[0][n-1] > dp [1][n-1] ? dp[0][n-1] : dp [1][n-1];

            System.out.println(result);
        }

    }
}
