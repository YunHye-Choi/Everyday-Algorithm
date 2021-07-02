package DP;
import java.util.Scanner;

// 문제: https://www.acmicpc.net/problem/1699
// 풀이: https://kosaf04pyh.tistory.com/235
// 혼자 생각하다 포기햇는데 생각보다 너무 단순하다..
// 풀이를 보면 쉬운데.. 왜 머리에서 풀이가 생각이 안날까?
// 깨달은점: 규칙이 지저분하다는 생각이 들면 과감히 버린다
// index 증가 규칙 이런것좀 찾지 말고 근본적인 수열의 규칙에 집중하자

public class boj_1699 {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int dp[] = new int [n+1];

        for(int i = 1; i <= n; i ++) {
            dp[i] = i;
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }

        System.out.println(dp[n]);
    }
}
