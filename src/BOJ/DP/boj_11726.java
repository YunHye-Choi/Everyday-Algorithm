// https://www.acmicpc.net/problem/11726
// 참고 블로그 : https://velog.io/@juhyun7793/%EB%B0%B1%EC%A4%80-11726-2N-Java
// 나머지연산 공식 => (A+B) % C = (A%C) + (B%C) 이기 때문에 d[n]을 구할 때마다 나머지 연산 해야 오버플로 발생안함
// 3회 연속 규칙 발견 시 점화식 세워보기
// 테케는 맞는데 오답이라면 문제 다시 읽어보기 (나머지연산 등)
import java.util.*;
public class boj_11726 {
    public static void main(String [] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if (i == 1) dp[i] = 1;
            else if (i == 2) dp[i] = 2;
            else dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }
        System.out.println(dp[n]%10007);
    }
    
}
