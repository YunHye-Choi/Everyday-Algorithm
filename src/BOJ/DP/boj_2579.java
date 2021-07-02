package DP;
import java.util.Scanner;

// 문제: https://www.acmicpc.net/problem/2579
// 풀이: https://sihyungyou.github.io/baekjoon-2579/
// 와인잔 문제보다 오히려 단순한 문제였다.
// 간단한 문제라도 제대로 리뷰하지 않으면 응용도 못함!
// 런타임 에러 원인: 배열에 대한 예외처리 제대로 안해서!!

public class boj_2579 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int [n];
        int dp[] = new int [n];
        for (int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        if(n >= 1)
            dp[0] = arr[0];
        if(n >= 2)
            dp[1] = Math.max(arr[0] + arr[1], arr[1]);
        if(n >= 3)
            dp[2] = Math.max(arr[0]+arr[2],arr[1]+arr[2]);

        for(int i=3;i<n;i++)
            dp[i] = Math.max(dp[i-3] + arr[i-1] + arr[i], dp[i-2] + arr[i]);

        System.out.println(dp[n-1]);
    }
}
