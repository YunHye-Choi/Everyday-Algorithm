// https://www.acmicpc.net/problem/10451
// dfs이용해서 쉽게 풀었음! 사이클 구할 때는 초기값을 같이 받아와주면 비교가 용이함
import java.util.*;
public class boj_10451 {
    public static ArrayList<Integer> [] graph;
    public static boolean visit[];
    public static int ans;
    public static void main(String[]args) {
        Scanner sc = new Scanner (System.in);
        int t = sc.nextInt();
        while(t-- != 0) {
            int n = sc.nextInt();
            graph = new ArrayList[n+1];
            visit = new boolean[n+1];
            ans = 0;
            for (int i = 1; i <= n ; i ++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 1; i <=n ; i++) {
                int end = sc.nextInt();
                graph[i].add(end);
            }

            for(int i = 1; i <= n; i++) {
                if(!visit[i]) {
                    dfs(i,i);
                }
            }

            System.out.println(ans);

        }
    }
    public static void dfs(int n, int first) {
        visit[n] = true;
        for(int i: graph[n]) {
            if (!visit[i]) {
                dfs(i, first);
            } else if (i == first) {
                ans ++;
                return;
            }
        }
    }
}
