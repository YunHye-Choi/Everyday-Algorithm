//https://www.acmicpc.net/problem/1697
// 접근 참고: https://smartpro.tistory.com/18
import java.util.*;
public class boj_1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = n;
        int ans = 0;
        int[] time = new int[100001];
        if (k <= n) ans = n-k;
        else {
            Queue<Integer> q = new LinkedList<>();
            q.add(x);
            time[x] = 1;
            while(!q.isEmpty()) {
                x = q.poll();
                if (x == k) {
                    ans = time[x] -1;
                    break;
                }
                if (2*x <= 100000) {
                    if(time[2*x] == 0) {
                        q.add(2*x);
                        time[2*x] = time[x] + 1;
                    }
                }
                if (x+1 <= 100000) {
                    if(time[x+1] == 0) {
                        q.add(x+1);
                        time[x+1] = time[x] + 1;
                    }
                }    
                if (x-1 >= 0) {
                    if(time[x-1] == 0) {
                        q.add(x-1);
                        time[x-1] = time[x] + 1;
                    }
                }
            }
            
            
        }
        System.out.println(ans);
    }
}
