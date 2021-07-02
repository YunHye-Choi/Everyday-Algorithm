package DP;

import java.util.Scanner;

// 문제: https://www.acmicpc.net/problem/2225
// 풀이참고: https://lmcoa15.tistory.com/64

public class boj_2225 {
    public static void main (String args[]) {
        Scanner scanner = new Scanner (System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        long dp[][] = new long [K+1][N+1];

        // initiate
        for (int k = 0; k < K; k ++) {
            dp[k][0] = 0;
        }
        for (int n = 0; n <= N; n++) {
            dp[0][n] = 0;
            dp[1][n] = 1;
        }

        // dp[k][n] = dp[k-1][n]의 규칙을 잘 생각하여 for문 작성
        for (int k = 2; k <= K; k++) {
            for (int n = 0; n <= N; n++) {
                for (int l = 0; l <= n; l++) {
                    dp[k][n] += dp[k-1][l];
                }
                dp[k][n] %= 1000000000;
            }
        }
        System.out.println(dp[K][N]);
    }
}