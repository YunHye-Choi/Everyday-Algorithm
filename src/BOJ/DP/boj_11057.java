// 10844 참고하여 생각 중...
// https://www.acmicpc.net/problem/11057
import java.util.*;
public class boj_11057 {
    public static final long mod = 10007;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [][] dp = new int[n+1][10];
        
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        if (n >= 2) {
            for (int i = 0; i <= 9; i++) {
                dp[2][i] = i+1;
            }
        }

        if (n >= 3) {
            for (int i = 3; i <= n; i++) { // 길이에 따라 2~n
                for (int j = 0; j <= 9; j++) { // 
                    for (int k = 0; k<= j; k++) {
                        dp[i][j] += dp[i-1][k];
                    }
                    dp[i][j] %= mod;
                }
            }
        }
        

        int ans  = 0;
        for(int i = 0; i <= 9; i ++) {
            ans += dp[n][i];
        }
        System.out.println(ans % mod);
    }
}
