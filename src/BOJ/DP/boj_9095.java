// 규칙을 찾는 문제를 풀 때는 초항 구할 때 침착하게 "실수없게" 하자.
// 근접하게 갔는데 덜렁대서 규칙 못찾음..
// https://www.acmicpc.net/problem/9095
// 풀이참고: https://fbtmdwhd33.tistory.com/73
import java.util.*;
public class boj_9095 {
    public static void main(String [] args ) {
        Scanner sc = new Scanner (System.in);
        int t = sc.nextInt();
        while(t-- != 0) {
            int n = sc.nextInt();
            int[] dp = new int [12];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int i = 4; i <= n; i ++) {
                dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
            }
            System.out.println(dp[n]);
        }
    }
}
