package DP;
import java.util.Scanner;
// 문제: https://www.acmicpc.net/problem/2133
// 타일채우기 문제! 생각중... 자기 전에 꼭 해결하구 자자
public class boj_2133 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int dp[] = new int [n+1];
        for(int i = 1;i <= n; i++){
            if(i%2 == 1)
                dp[i] = 0;
        }
    }


}
