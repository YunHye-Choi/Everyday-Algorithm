import java.util.*;
public class boj_11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp1 = new int[n]; // 앞쪽부터 가장 긴 증가
        int[] dp2 = new int[n]; // 뒤쪽부터 가장 긴 증가

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dp1[0] = 1;
        dp2[n-1] = 1;

        int max1 = 1;
        int idx1 = 0;
        for (int i = 1; i < n; i ++) {
            dp1[i] = 1;
            for (int j = 0; j < i; j ++) {
                if (arr[j] < arr[i] && dp1[i] == dp1[j]) {
                    dp1[i] = dp1[j] + 1;
                }
            }
            if ( max1 > dp1[i]){
                max1 = dp1[i];
            }
        }

        int max2 = 1;
        int idx2 = n-1;
        for (int i = n-2; i >= 0; i --) {
            dp2[i] = 1;
            for (int j = n-1; j > i; j--) {
                if (arr[j] < arr[i] && dp2[i] == dp2[j]) {
                    dp2[i] = dp2[j] + 1;
                }
            }
            if ( max2 > dp1[i]){
                max2 = dp1[i];
            }
        }

        int max = 1;
        // for (int i = 0; i < n-1; i ++) {
        //     if (arr[i] < arr[j])
        //         max = max < dp1[i] + dp2[j] ? dp1[i] + dp2[j] : max; 
        //     j++;
        // }

        for (int i = 0; i < n; i ++) {
            if (dp1[i] == max1) {
                for (int j = i + 1; j < n; j ++) {
                    if (arr[i] > arr[j])
                        max = Math.max(max, dp2[j] + max1);
                }
            }
        }
        

        for (int i = 0; i < n; i ++) {
            if (dp2[i] == max2) {
                for (int j = i - 1; j >= 0; j --) {
                    if (arr[i] > arr[j])
                        max = Math.max(max, dp2[j] + max2);
                }
            }
        }
        // max = Math.max(max1, max);
        // max = Math.max(max2, max);

        System.out.println(max);
        
    }
}
