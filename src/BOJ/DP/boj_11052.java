package DP;

// 문제: acmicpc.net/problem/11052
// 풀이: https://yabmoons.tistory.com/522

import java.util.Scanner;

public class boj_11052 {
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p[] = new int [n+1];
        p[0] = 0;
        for (int i = 1; i < n+1; i++) {
            p[i] = scanner.nextInt();
        }
        int [] dp = new int [n+1];
        dp[0] = p[0];
        dp[1] = p[1];
        /*
        DP[N]의 값을 구하기 위해서는
        Card[1] + DP[N - 1]
        Card[2] + DP[N - 2]
        Card[3] + DP[N - 3]
        Card[4] + DP[N - 4]
        ...
        Card[N] + DP[0]
        의 값들을 비교해서 최댓값을 갖는 금액이 N장의 카드를 구매할 때, 지불해야 하는 최대금액이 된다.

        * Card[1] = B 는 "1장의 카드가 들어있는 카드팩의 가격은 B원입니다." 를 의미한다.
        */
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + p[j]);
            }
        }
        System.out.println(dp[n]);
    }
}