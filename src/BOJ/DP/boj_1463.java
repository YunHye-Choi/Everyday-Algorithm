// https://www.acmicpc.net/problem/1463
// 내가 풀었음, dp이용, Integer.MAX_VALUE 기억하장!
import java.util.*;

public class boj_1463 {
    public static void main (String [] args ){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        int [] dp = new int [n+1];
        // dp[1] = 0 임
        for(int i = 2; i <= n; i++) {
            //int tmp= i;
            int cand1 = Integer.MAX_VALUE, cand2 = Integer.MAX_VALUE, cand3 = Integer.MAX_VALUE;
            if (i % 3 == 0) {
                cand1 = dp[i/3] + 1;
            } 
            if (i % 2 == 0) {
                cand2 = dp[i/2] + 1;
            } 
            cand3 = dp[i-1] + 1;
            
            dp[i] = cand1 < cand2 ? cand1 : cand2;
            dp[i] = dp[i] < cand3 ? dp[i] : cand3;
        }
        System.out.println(dp[n]);
    } 
}
