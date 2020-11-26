package DP;
import java.util.Scanner;

// 해결중!!
// 고려하지 못한 경우: 제곱수+1, 제곱수+2, 제곱수+3.. 이런 경우만 생각하느라 18같은 경우 (9+9)를 고려 못했다..!
// 풀이보기 아까우니까 더 생각해보자!

public class boj_1699 {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q= 1;
        while (Math.pow(q,2) < n)
            q++;
        int size = (int)Math.pow(q,2) ;
        int dp[] = new int [size];

        int j = 0, k = 0;
        for(int i=0;i<size;i++) {
            if (i == j) { // 제곱수가 나타나는 주기마다 dp에 1삽입
                dp[i] = 1;
                if (i == 0)
                    k = 3;
                else k += 2;
                j += k;
                for (int x = 0; x < k-1 && i < n ;x++) {
                    dp[x+i+1] = dp[x] + dp[i];
                }
            }
        }
        for(int i=0;i<n;i++)
            System.out.println((i+1)+": "+dp[i]);
        System.out.println(dp[n-1]);

    }
}
