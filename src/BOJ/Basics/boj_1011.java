// https://www.acmicpc.net/problem/1011
// 내 풀이와 완전히 다른 접근방식.. 규칙 찾는 문제였다.
// 블로그 풀이: https://st-lab.tistory.com/79


import java.util.*;
public class boj_1011 {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] calc = {1, 0 , -1};
        while (t-- != 0) {
            int x = sc.nextInt(); // 현재 위치
            int y = sc.nextInt(); // 목표 위치

            int ans = 0;
            int start = 0;
            int end = y-x;

            if (end <= 2) {
                ans = end;
            } else {
                // 마지막 한번은 규칙에서 제외되므로 미리 빼기
                ans = 1;
                end --;

                // k를 결정할 때 prevK+1, prevK, prevK-1 순으로 가정해보면서
                // 해당 k가 최대라는 가정하에
                // 예측 sum을 구해보고, sum이 y-x보다 작거나 같으면 그 값으로 결정, 아니면 다음 후보 불러오기
                int k = 1;
                int sum = k;
                int prevK = 0;
                while (true) {
                    prevK = k;
                    for (int i = 0; i < 3; i ++) {
                        k = prevK + calc[i];
                        
                        if (getMinSum(k) <= end) {
                            break;
                        }
                    }
                    System.out.println("K : " + k);
                    sum += k;
                    if (sum == end) break;
                }
            }

            System.out.println(ans);
        }
    }
    private static int getMinSum (int k) {
        int sum = 0;
        for (int i  = 1; i < k; i++) {
            sum += i;
        }
        sum *=2 ;
        sum += k;
        return sum;
    }
}