// https://www.acmicpc.net/problem/11053
// https://developer-mac.tistory.com/71 를 참고했으나 불필요한 조건 제거하여 해결
import java.util.*;
public class boj_11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr, dp;
        
        arr = new int[n];
        dp = new int[n];

        for (int i = 0; i < n; i ++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = 1;
        int max = 1;

        for (int i = 1; i < n; i ++) {
            dp[i] = 1;
            for (int j = 0; j < i; j ++) {
                if (arr[i] > arr[j] && dp[i] == dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = max < dp[i] ? dp[i] : max;
        }
        System.out.println(max);
    }
}
