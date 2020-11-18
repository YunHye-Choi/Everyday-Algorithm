package DP;
import java.util.*;
// 정답여부 확인 안함
// 참고블로그 : https://wootool.tistory.com/96
public class boj_11053 {
    public static void main (String[] args)  {
        Scanner scanner = new Scanner (System.in);
        int n = scanner.nextInt();
        int arr[] = new int [n+1];
        int dp[] = new int [n+1];
        for (int i = 1; i <= n; i ++) {
            arr[i] = scanner.nextInt();
        }
        int dp_max = 0;
        for (int i = 1; i <= n; i ++) {
            int min = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    min = min < dp[j] ? dp[j] : min;
                }
            }
            dp[i] = min + 1;
            dp_max = dp_max < dp[i] ? dp[i] : dp_max;
        }
        System.out.println(dp_max);
    }
}
