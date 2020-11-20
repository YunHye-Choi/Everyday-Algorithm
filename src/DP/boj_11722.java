package DP;
import java.util.*;

// 문제: https://www.acmicpc.net/problem/11722
// 그냥 11053문제 응용한 것 뿐이라. 의미없다고 봄
// 11053 문제의 원리를 정확히 간파한것에 의미를 두자!
// I solved!

public class boj_11722 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = scanner.nextInt();
        int arr[] = new int [n];
        int dp[] = new int [n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0;j<i;j++) {
                if (arr[j] > arr[i] && dp[i]<= dp[j]) {
                    dp[i] = dp[j] +1;
                }
            }
        }
        int dp_max = 0;
        for (int i=0;i<n;i++)
            dp_max = Math.max(dp_max, dp[i]);
        System.out.println(dp_max);
    }
}
