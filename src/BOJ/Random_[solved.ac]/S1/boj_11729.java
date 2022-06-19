// https://www.acmicpc.net/problem/11729
// 풀이 참고: https://st-lab.tistory.com/96
// 아이디어는 맞음 (완벽하게!)
// 입출력때문에 시간초과가 나서... 풀이를 참고했다.
// StringBuilder: 현업에서도 많이 쓰고 시간도 잘 줄으니 사용법을 잘알아두자.


import java.util.*;

public class boj_11729 {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] * 2 + 1;
        }
        if (n > 1) {
            System.out.println(dp[n]);
            move(1, 3, 2, n);
            System.out.println(sb);
        }else {
            System.out.println("1");
            System.out.println("1 3");
        }
        
    }
    public static void move(int a, int b, int c, int lev) {
        if (lev == 1) {
            sb.append(a + " " + b + "\n");
            return;
        }
        move(a, c, b, lev-1);
        move(a, b, c, 1);
        move(c, b, a, lev-1);
    }

}
