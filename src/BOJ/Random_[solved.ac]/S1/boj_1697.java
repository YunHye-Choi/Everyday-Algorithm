package S1;

import java.util.*;
// class Pair{
//     int depth;
//     int val;
//     public Pair (int depth, int val) {
//         this.depth = depth;
//         this.val = val;
//     }
// }
public class boj_1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = n;
        int ans = 0;
        boolean[] visited = new boolean[100001];
        if (k <= n) ans = n-k;
        else {
            Queue<Integer> q = new LinkedList<>();
            q.add(2*x);
            q.add(x+1);
            q.add(x-1);
            while (!q.isEmpty()) {
                int num = q.poll();
                visited[num] = true;
                if (num == k) {
                    break;
                } else {
                    if (!visited[num*2]) {
                        q.add(num*2);
                        visited[num*2] = true;
                    }
                    if (!visited[num+1]) {
                        q.add(num+1);
                        visited[num+1] = true;
                    }
                    if (!visited[num-1]) {
                        q.add(num-1);
                        visited[num-1] = true;
                    }
                }
                
            }
        }
        System.out.println(ans);
    }
}
