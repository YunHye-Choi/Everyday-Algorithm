// https://www.acmicpc.net/problem/9461
// 스스로 해결, 규칙이 쉬우면 type에 유의하자!
import java.util.*;
public class boj_9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int t = sc.nextInt();
        long [] dp = new long [100];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < 100; i++) {
            dp[i] = dp[i-2] + dp [i-3];
        }
        long [] ans = new long [t];
        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            ans[i] = dp[n-1];
        }
        for(long num: ans) {
            System.out.println(num);
        }
    }
}
