// 풀이 참고:https://yabmoons.tistory.com/536 해보기
// 해결중
import java.util.*;
public class boj_2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int [n+1];
        if (n >= 2)
            dp[2] = 3; // 초항
        if (n % 2 == 0) {
            for (int i = 4; i <= n; i+=2) {
                int k = i-2;
                dp[i] = dp[k] * dp[2] + 2;
                while(k > 2) {
                    k -= 2;
                    dp[i] += dp[k] * 2;
                }
            }
        }
        System.out.println(dp[n]);
    }
}
