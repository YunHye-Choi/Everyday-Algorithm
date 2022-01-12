// 어느 팀에도 속하지 않는 학생 수를 구해야 한다..
// 틀렸습니다. 답보자...하
import java.util.*;
public class boj_9466 {
    public static boolean [] check;
    public static int [] graph;
    public static boolean [] team;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0) {
            int n = sc.nextInt();
            int ans = 0;
            graph = new int [n+1];
            check = new boolean[n+1];
            team = new boolean[n+1];
            for (int i = 1; i <= n ; i++) {
                graph[i] = sc.nextInt();
            }
            for (int i = 1; i <= n ; i++) {
                if (!check[i] && dfs(i, graph[i])) {
                    dfsAddTeam(i, graph[i]);
                }
            }
            for (boolean tf : team) {
                if (!tf) ans ++;
            }
            ans --;
            System.out.println(ans);
        }
    }
    public static boolean dfs(int i, int n) {
        check[i] = true;
        if (!check[n] && i != n) {
            dfs(n, graph[n]);
            return false;
        } 
        return true;
    }
    public static void dfsAddTeam(int i, int n) {
        team[i] = true;
        if (!team[n] && i != n) {
            dfsAddTeam(n, graph[n]);
        } 
    }
}
