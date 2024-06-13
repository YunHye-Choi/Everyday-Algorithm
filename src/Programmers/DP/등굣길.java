// 문제: https://school.programmers.co.kr/learn/courses/30/lessons/42898
import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int dp[][] = new int [m+1][n+1];
        int divideBy = 1000000007;

        dp[1][1] = 1;
        initiate(dp, puddles);
        for(int i = 1 ; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (dp[i][j] == -1)
                    continue;
                if (i-1 >= 1) {
                    dp[i][j] += (dp[i-1][j] == -1 ? 0 : dp[i-1][j])%divideBy;
                }
                if (j-1 >= 1) {
                    dp[i][j] += (dp[i][j-1] == -1 ? 0 : dp[i][j-1])%divideBy;
                }
            }
        }
        return dp[m][n] % divideBy;
    }
    private void initiate(int[][] dp, int[][] puddles){
        for (int i = 0; i < puddles.length ; i ++){
            int m = puddles[i][0];
            int n = puddles[i][1];
            dp[m][n] = -1;
        }
    }
}