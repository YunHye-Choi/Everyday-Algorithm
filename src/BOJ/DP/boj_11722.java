// https://www.acmicpc.net/problem/11722
// 비슷한 문제 푼 적 있다고 발 동동구르며 "뭐였지" 할 시간에 
// 초심으로 돌아가서 차근차근 생각하자... :(
// 풀이 참고: 11053(가장 긴 증가하는 부분 수열)
import java.util.*;
public class boj_11722 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int dp[] = new int[n];
        for (int i = 0; i < n; i ++) {
            arr[i] = sc.nextInt();
        }
        dp[0] = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j ++) {
                if (arr[j] > arr[i] && dp[j] == dp[i])
                    dp[i] = dp[j] + 1;
            }
            ans = ans < dp[i] ? dp[i] : ans;
        }

        System.out.println(ans);
    }
}
