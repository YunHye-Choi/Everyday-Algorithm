// https://www.acmicpc.net/problem/1699
// 풀이 참고: https://hidelookit.tistory.com/121 
// 점화식 찾기 어려웠던 문제
// i번째 보다 작은 제곱수를 빼고 남은 index에 해당하는 dp 값 + 1 (dp[i-j*j] + 1)과 
// dp[i] 중에서의 최소 값을 구한다
// 포인트는 제곱수 몇개의 조합이든, 한 제곱수만 빼주면 나머진 어차피 dp에 있다는 것
// 제곱 경우의 수 모두 풀어헤치고 나서 그 합들의 연관성을 통해 최적 해를 구하는 것이 point!
// "규칙을 찾아야 함"!!!
import java.util.*;
public class boj_1699 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // int[] arr = new int [n+1];
        int[] dp = new int [n+1];
        dp[1] = 1;
    	for(int i = 2; i <= n; i ++) {
    		dp[i] = i;
    		for (int j = 1; j*j <=i; j++) {
    			dp[i] = Math.min(dp[i], dp[i-j*j]+1);
    		}
    	}
        System.out.println(dp[n]);
    }
    
}
