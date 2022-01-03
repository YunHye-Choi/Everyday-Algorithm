//https://www.acmicpc.net/problem/1052
// 혼자 폴어본 결과 문제에 주어진 테케는 맞았지만(그 와중에 하나는 timeout), 제출 하니 답은 틀림.
// 아래는 블로그 풀이 (https://velog.io/@estry/%EB%B0%B1%EC%A4%80-1052-%ED%92%80%EC%9D%B4)

import java.util.*;
public class boj_1052 {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        // 내풀이
        // int ans = 0;
        // int sit = 0;
        // while(true) {
            
        //     if (n % 2 == 1) {
        //         ans ++;
        //         n ++;
        //         System.out.println("홀수 " + ans);
        //         continue;
        //     }
        //     if (n % 2 == 0) {
        //         int _n = n;
        //         while(_n > 0) {
        //             if(_n == k) {
        //                 sit = 1;
        //                 break;
        //             }
        //             if (_n % 2 == 1) {
        //                 sit = -1;
        //                 break;
        //             }
        //             _n /= 2;
        //         }
        //         if (sit == 1) {
        //             break;
        //         } else {
        //             ans ++;
        //             n ++;
        //             System.out.println("짝수 도중 break " + ans);
        //             continue;
        //         }
        //     }
        // }

        // 블로그 풀이
        // 2의 제곱수인 n은 하나의 물병으로 합칠 수 있다.
        // n%2 == 1인 경우 들고가야하는 물병이 1개 더 생긴다
        int ans = 0;
        if (n <= k) ans = 0; // 무조건 물병 추가구입 필요x인 경우
        else {
            int r = 0;
            while (true) {
                int cnt = 0;
                int num = n;
                while(num != 0) {
                    if (num % 2 == 1)
                        cnt ++;
                    num /= 2;
                }
                if (cnt <= k)
                    break;
                r ++;
                n ++;
            }
            ans = r;
        }
        System.out.println(ans);
    }
}
