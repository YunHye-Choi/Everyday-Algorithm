package DP;
import java.util.Scanner;

// 문제: https://www.acmicpc.net/problem/1912
// I solved!!
// 이전 dp와 현재 arr값 비교, 더 큰 값을 현재 dp에 저장

public class boj_1912 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int [n];
        int dp[] = new int [n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i] + dp[i-1], arr[i]);
        }
        int dp_max= -100000000;
        for(int i=0;i<n;i++)
            dp_max = Math.max(dp_max, dp[i]);

        System.out.println(dp_max);
    }
}
