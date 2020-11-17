package DP;
import java.util.*;

// problem URL: https://www.acmicpc.net/problem/2156
// solution from: https://wootool.tistory.com/94

public class boj_2156 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = scanner.nextInt();
        int arr[] = new int [n];
        int dp[] = new int [n];
        for (int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        if(n == 1) {
            System.out.println(arr[0]);
            return;
        }
        dp[0] = arr[0];
        if (n>=2)
            dp[1] = dp[0] + arr[1];
        if (n>=3){
            dp[2] = max(dp[1], arr[2]+arr[1]);
            dp[2] = max(dp[0] + arr[2], dp[2]);
        }

        for (int i=3;i<n;i++) {
            // i번째 것 먹을때, i-1번째 것 먹는 경우 vs i-1번째 것 안먹는 경우
            dp[i] = max (arr[i] + arr[i-1] + dp[i-3], arr[i]+ +dp[i-2]);
            // i번째 것 먹지 않는 경우 vs 먹는 경우
            dp[i] = max(dp[i-1], dp[i]);
        }
        System.out.println(dp[n-1]);

    }
    private static int max (int a, int b) {
        return a > b ? a : b;
    }
}
