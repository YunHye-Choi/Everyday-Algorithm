// https://www.acmicpc.net/problem/2193
// 자꾸 답이 틀리면 자료형 바꿔보기!
import java.util.*;
public class boj_2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        // '이친수'의 규칙 찾으니 피보나치
        long[] dp = new long [n+1];
        dp[0] = 0;
        //if (n >= 1) {
            dp[1] = 1;
        //}
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);
    }
}