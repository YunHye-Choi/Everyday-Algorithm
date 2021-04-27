package DP;
import java.util.*;
// 문제: https://www.acmicpc.net/problem/11053
// 참고블로그 : https://developer-mac.tistory.com/71

public class boj_11053 {
    public static void main (String[] args)  {
        Scanner scanner = new Scanner (System.in);
        int n = scanner.nextInt();
        int arr[] = new int [n];
        int dp[] = new int [n];
        for (int i = 0; i < n; i ++) {
            arr[i] = scanner.nextInt();
        }
        // 각 dp에 그 요소(arr[i])로 끝나는 최장길이 증가 수열을 j로 순회하며(안쪽 for문) 구하고
        // dp 중 최대값을 출력하면 된다
        dp[0] = 1;
        for (int i = 1; i < n; i ++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 최대 길이 증가수열 찾기
                // arr[j]가 arr[i]보다 크면 증가했다는 의미
                // dp[i] <= dp[j]면 최장길이라는 의미
                if (arr[j] < arr[i] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int dp_max = 0;
        for (int i :dp) {
            dp_max = Math.max (dp_max, i);
        }
        System.out.println(dp_max);
    }
}
