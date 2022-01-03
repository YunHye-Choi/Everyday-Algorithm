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

                // 처음은 무조건 한칸
                int k = 1;
                int sum = k;
                int prevK = 0;
                while (true) {
                    prevK = k;
                    for (int i = 0; i < 3; i ++) {
                        k = prevK + calc[i];
                        // if (k == 0)
                    }
                    if (sum == end) break;

                }

            }

            System.out.println(ans);
        }
    }
}