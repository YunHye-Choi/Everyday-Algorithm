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
        int maxdp = 1;
        for(int i = 1; i < n; i ++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {                
                if(arr[j] > arr[i] && dp[i] == dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
            maxdp = maxdp < dp[i] ? dp[i] : maxdp;
        }
        System.out.println(maxdp);
    }
}
