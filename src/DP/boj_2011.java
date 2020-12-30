package DP;

import java.util.Scanner;

// 문제: https://www.acmicpc.net/problem/2011
// 풀이참고: https://geehye.github.io/baekjoon-2011/#

public class boj_2011 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String str = scanner.nextLine();
        int n = str.length();
        long [] dp = new long[n+1];
        dp[0] = 1;
        if (n > 1)
            dp[1] = 1;

        // 예외처리: 맨 앞글자가 0인 경우
        if (str.charAt(0) == '0')
            System.out.println(0);

        // 예외처리: 맨뒤의 앞글자가 1 또는 2가 아닐때 맨 뒤글자가 0인 경우
        else if (str.charAt(n-1) == '0' && str.charAt(n-2) != '1' && str.charAt(n-2) != '2')
            System.out.println(0);

        else {
            for (int i = 2; i <= n; i++) {
                int temp = Integer.parseInt(str.charAt(i-1) + "");
                if (temp > 0)
                    dp[i] = dp[i-1] % 1000000; // 일단 이전 dp와 같은 값으로 초기화 (한 자리만 붙었기 때문)

                temp += Integer.parseInt(str.charAt(i-2) + "")*10;
                if (10 <= temp && temp <= 26) // 이전자리수를 같이 보았을 때 알파벳 범위 내면
                    dp[i] = (dp[i] + dp[i-2]) % 1000000; // i-2번째까지 경우의 수에 두자리를 붙인 것과 같기 때문에 이와같이 연산함
            }
            System.out.println(dp[n]);
        }
    }
}
