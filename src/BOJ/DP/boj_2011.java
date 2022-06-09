// https://www.acmicpc.net/problem/2011
// 풀이 참고: https://iamheesoo.github.io/blog/algo-boj2011
// 규칙 찾을때 단순 계산으로만 찾으려 하지 말고 왜 그값이 나오는 지 생각하며 접근하기!!!
// 규칙에 따라 경우의 수를 나누고, 그 경우의 수에 따라 조건문을 만들면 빈틈없이 짤 수 있음
// ㄴ 이 문제의 경우 arr[i-1] , arr[i] 를 
//    1. 각 한자리수로만 생각 2. 두자리수로만 생각 3. 각 한자리수로 생각 + 두자리수로 생각 4. 불가능한경우
//    와 같이 규칙("가능한 자리수에 따라 점화식이 달라진다")에 따라 경우의 수를 나누고 각 case 에 해당하는 것들을 조건문으로 구현 

import java.util.*;

public class boj_2011{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] charArr = str.toCharArray();
        int mod = 1000000;

        int n = charArr.length;
        int [] arr = new int [n+1];
        int [] dp = new int[n+1];

        for (int i = 1; i <= n; i ++) {
            arr[i] = charArr[i-1] - '0';
        }
        dp[0] = 1;
        if (arr[1] == 0) dp[1] = 0;
        else {
            dp[1] = 1;
        }

        for (int i = 2 ; i <= n; i++) {
            if (arr[i] == 0) {
                if (arr[i-1] == 1 || arr[i-1] == 2) {
                    dp[i] = dp[i-2];
                } else {
                    break;
                }
            } else {
                if (arr[i-1] == 0) {
                    dp[i] = dp[i-1];
                } else{
                    int num = arr[i-1] * 10 + arr[i];
                    if(1 <= num && num <= 26) {
                        dp[i] = (dp[i-1] + dp[i-2]) % mod;
                    } else {
                        dp[i] = dp[i-1];
                    }
                }
            }
        }
        System.out.println(dp[n]);
    }
}