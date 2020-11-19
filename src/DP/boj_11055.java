package DP;
import java.util.*;

// 미완
// 밀렸다..ㅠㅠ

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
                if (arr[i] > arr[j] && dp[i] < dp[j] + arr[i]) {
                    dp[i] = dp[j] + arr[i];
                } else {
                    dp[i] = dp[j];
                }
            }
        }
        int dp_max = 0;
        for (int i : dp) {
            System.out.println(i);
            dp_max = Math.max(dp_max, i);
        }
        System.out.println(dp_max);
    }
}
