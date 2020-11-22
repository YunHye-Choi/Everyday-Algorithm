package DP;
import java.util.Scanner;

// 문제: https://www.acmicpc.net/problem/11054
// 미해결... 풀리정리 아이패드 연습장

public class boj_11054 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = scanner.nextInt();
        int arr[] = new int [n];
        int dp[] = new int [n];
        for (int i = 0; i < n; i ++) {
            arr[i] = scanner.nextInt();
        }

        int max = 0;
        int max_index = 0;
        for (int i = 0; i<n;i++){
            if(max < arr[i]) {
                max = arr[i];
                max_index = i;
            }
        }
        dp[0] = 1;
        boolean peek = false;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0;j < i ; j++) {
                if (peek) { // peek 찍었으니 감소 부분수열 찾자!
                    if (arr[i] > arr[j] && dp[i] <= dp[j]) {
                        dp[i] =  dp[j] + 1;
                    }
                } else { // peek 아직 안찍었다. 증가 부분수열 구하자
                    if (arr[i] < arr[j] && dp[i] <= dp[j]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            if(arr[i] == max) {
                peek = true;
                if (i != max_index) {
                    dp[i] = 1;
                    for (int j = 0;j < i;j++) {
                        if (arr[i] > arr[j] && dp[i] <= dp[j]) {
                            dp[i] =  dp[j] + 1;
                        }
                    }
                    if (dp[max_index] < dp[i]) {
                        max_index = i;
                    }
                }
            }

        }
        int dp_max1 = 0, dp_max2 = 0;
        for (int i = 0; i<max_index;i++)
            dp_max1 = Math.max(dp_max1, dp[i]);
        for (int i = max_index; i<n;i++)
            dp_max2 = Math.max(dp_max2, dp[i]);
        int result = dp_max1 + dp_max2;
        System.out.println(dp_max1 +"+"+ dp_max2 +"="+  result);
    }
}
