// https://www.acmicpc.net/problem/1011
// 나에겐 너무 어려웠던 문제..
// 확실한건 범위가 저따위면(2^32) O(n)이든 뭐든 절대 loop는 안된다.. 알자네~
// 풀이참고: https://hyunipad.tistory.com/65
import java.util.*;
public class boj_1011{
    public static void main(String[] args ) {
        Scanner sc = new Scanner (System.in);
        int t = sc.nextInt(); // y-x값 저장
        int[] ans = new int[t];
        for (int i = 0; i < t; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int dist = y - x;
            int max =(int) Math.sqrt(dist);
            if (Math.sqrt(dist) == max) {
                ans[i] = max * 2 - 1;
            }
            else if (dist <= Math.pow(max,2) + max ) {
                ans[i] = max * 2;
            } else{
                ans[i] = max * 2 + 1;
            }
            
        }
        for(int a: ans) {
            System.out.println(a);
        }
    }
}