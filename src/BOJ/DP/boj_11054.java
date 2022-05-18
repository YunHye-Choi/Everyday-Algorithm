// https://www.acmicpc.net/problem/11054
// 풀이: 1년전 내 풀이..
// 반례를 찾기 어려울 때는 사례에 집착하지 말고, logically right인지를 철저히 생각해보자!
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
        for (int i = 1; i < n; i ++) {
            dp1[i] = 1;
            for (int j = 0; j < i; j ++) {
                if (arr[j] < arr[i] && dp1[i] <= dp1[j]) {
                    dp1[i] = dp1[j] + 1;
                }
            }
            max1 = Math.max(max1, dp1[i]);
        }

        int max2 = 1;
        for (int i = n-2; i >= 0; i --) {
            dp2[i] = 1;
            for (int j = n-1; j > i; j--) {
                if (arr[j] < arr[i] && dp2[i] <= dp2[j]) {
                    dp2[i] = dp2[j] + 1;
                }
            }
            max2 = Math.max(max2, dp2[i]);
        }

        int max =0;

        ////////// ㅠㅠ index가 같은 것끼리 더해야 바이토닉 수열이 나옴..!! 
        for (int i = 0; i < n; i ++) {
            max = Math.max(dp1[i], dp2[i]);
        }

        System.out.println(max-1);
        
    }
}
