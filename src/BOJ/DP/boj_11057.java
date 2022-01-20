// 10844 참고하여 생각 중...
// https://www.acmicpc.net/problem/11057
import java.util.*;
public class boj_11057 {
    public static final long mod = 10007;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [][] dp = new int[n+1][10];
        
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = j; k<= 9; k++) {

                }
            }
        }
    }
}
