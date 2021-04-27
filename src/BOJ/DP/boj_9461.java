package DP;
import java.util.Scanner;

// problem: https://www.acmicpc.net/problem/9461
// I solved

public class boj_9461 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int T = scanner.nextInt();
        long [] tc = new long [T];
        for (int c = 0; c < T; c++) {
            int n = scanner.nextInt();
            long [] p = new long [n];
            // initialize p[0~4]
            p[0] = 1;
            if (n > 1) p[1] = 1;
            if (n > 2) p[2] = 1;
            if (n > 3) p[3] = 2;
            if (n > 4) p[4] = 2;
            for (int i = 5; i < n;i++) {
                p[i] = p[i-1] + p[i-5];
            }
            tc[c] = p[n-1];
        }
        for (long ans:tc) {
            System.out.println(ans);
        }
    }
}
