package DP;
import java.util.Scanner;
// 문제: https://www.acmicpc.net/problem/2133
// 풀이: https://kosaf04pyh.tistory.com/236
// 다음부터는 최소 1시간은 생각해볼것..! (그래도 어려웠다)

public class boj_2133 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int dp[] = new int [n+1];
        // n이 짝수인 경우만 가능
        if(n % 2 == 0){
            dp[0] = 1;
            if (n >= 2)
                dp[2] = 3;

            for(int i = 4; i <= n ; i++){
                // 이전 도형 오른쪽에 2*3 도형 1개가 붙으면
                // 2*3 도형은 3가지 경우의 수를 가지므로 이전 dp에 3을 곱한다
                dp[i] = dp[i-2] * 3;
                
                // i*3의 새로운 도형 모양 추가. 새로운 도형은 경우의 수가 항상 2임
                // i-j,... ,i-4, i-2번째 dp까지 누적해서 추가해야하므로 for문 이용
                for(int j = 4; j <= i;j += 2) {
                    dp[i] += dp[i-j] * 2;
                }
            }
        }
        
        // n이 홀수인 경우는 불가능
        if (n % 2 == 1)
            dp[n] = 0;
        System.out.println(dp[n]);
    }
}
