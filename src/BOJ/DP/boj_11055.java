// 내가 풀었다!! 음하하하
// 틀렸을때는 반례를 찾아서 어떻게 해소할 수 있을 지 고민하는것이 중요함
// https://www.acmicpc.net/problem/11055
import java.util.*;
public class boj_11055 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];
        for (int i = 0 ; i < n; i ++) {
            arr[i] = sc.nextInt();
            dp[i] = arr[i];
        }

        for (int i = 1; i < n; i ++) {
            int k = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] > k) {
                    k = dp[j];
                    dp[i] = dp[j] + arr[i];
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int num:dp) {
            ans = num > ans ? num : ans;
        }

        System.out.println(ans);
    }
}
