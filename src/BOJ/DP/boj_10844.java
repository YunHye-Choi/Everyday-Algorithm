// https://www.acmicpc.net/problem/10844
// 그냥 접근을 잘못함 .. 너무어렵다 ㅠ
// https://dundung.tistory.com/11
import java.util.*;
public class boj_10844 {
    public final static long mod = 1000000000;
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // dp[i][j] : 길이가 i이고 마지막 자리 수가 j인 계단수의 경우의 수 저장
        long [][] dp = new long [n+1][10];

        // 길이가 1인 경우
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j+1];
                }else if (j == 9) {
                    dp[i][j] = dp[i-1][j-1];
                } else{
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
                }
                dp[i][j] %= mod;
            }
        }
        long ans = 0;
        for (int i = 0; i <= 9; i ++) {
            ans += dp[n][i];
        }
        // ans %= mod;
        System.out.println(ans % mod);
    }
    
}