// https://www.acmicpc.net/problem/2156
// 내가 해냈다!!!! XD
import java.util.*;
public class boj_2156 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int[] arr = new int [n];
        int[] dp = new int [n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        if (n == 1) {
            System.out.println(arr[0]);
            return;
        }
        if (n == 2) {
            System.out.println(arr[0] + arr[1]);
            return;
        }
        int max_;
        max_ = Math.max(arr[0] + arr[1], arr[1] + arr[2]);
        max_ = Math.max(max_, arr[0] + arr[2]);
        if (n == 3) {
            System.out.println(max_);
            return;
        }

        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = max_;

        
        for (int i = 3; i < n ; i++) {
            int max = Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]);
            max = Math.max(dp[i-1], max);
            dp[i] = max;
        }
        
        System.out.println(dp[n-1]);
    }
}
