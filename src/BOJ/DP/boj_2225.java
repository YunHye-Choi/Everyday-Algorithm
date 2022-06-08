// 초항 생각 잘하자!
// Arrays.fill(arr, value); // 나중에 활용하자!
// 나머지 구하라는 문제는 무조건 loop의 한가운데에! (가장 많이 실행할 수 있는 위치에)
// https://www.acmicpc.net/problem/2225
import java.util.*;
public class boj_2225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int div = 1000000000;
        int[][] dp = new int[n+1][k+1];

        // 초항
        for (int i = 0; i <=k; i++){
            dp[0][i] = 1;
            dp[1][i] = i;
        }
        for (int i = 0; i <= n; i ++) {
            dp[i][1] = 1;
        }
        if(k >= 2) {
            for (int i = 0; i <= n; i ++) {
                dp[i][2] = i+1;
            }
        }

        for (int i = 2; i <= n; i++){
            for (int j = 3; j <= k; j++) {
                for (int idx = 0; idx <= i; idx++) {
                    dp[i][j] += dp[idx][j-1];
                    dp[i][j] %= div;
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
