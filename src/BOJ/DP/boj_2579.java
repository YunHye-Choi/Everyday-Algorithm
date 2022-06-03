// https://www.acmicpc.net/problem/2579
// 내가 풀었다!
// 규칙을 발견해내야겠다는 마음으로 차분하게 생각하는 것이 중요함
import java.util.*;
public class boj_2579 {
    public static void main(String []args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int [n];
        for (int i = 0; i < n ;i ++) {
            arr[i] = sc.nextInt();
        }
        dp[0] = arr[0];
        if (n > 1) {
            dp[1] = dp[0] + arr[1];
        }
        if (n > 2) {
            dp[2] = Math.max(arr[0], arr[1]) + arr[2];
        }
        for (int i = 3; i < n; i ++) {
            dp[i] = Math.max(dp[i-3] + arr[i-1], dp[i-2]) + arr[i];
        }

        System.out.println(dp[n-1]);
    } 
}
