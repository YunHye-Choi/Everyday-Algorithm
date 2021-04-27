package DP;
import java.util.*;

// 문제: https://www.acmicpc.net/problem/11055
// I solved it !!! (11053풀이 참고함)
// DP문제 풀때: 항상 손으로 직접 써보고 규칙찾기

public class boj_11055 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        int dp[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                // 증가하면서(앞), 그 합이 최대인 값(뒤)
                if (arr[i] > arr[j] && dp[i] < dp[j] + arr[i]) {
                    dp[i] = dp[j] + arr[i];
                }
            }
        }
        int dp_max = 0;
        for (int i : dp) {
            System.out.print(i + " ");
            dp_max = Math.max(dp_max, i);
        }
        System.out.println(dp_max);
    }
}
