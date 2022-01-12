// 어느 팀에도 속하지 않는 학생 수를 구해야 한다..
// https://alwaysbemoon.tistory.com/215
import java.util.*;
public class boj_9466 {
    // finished: 팀원 여부를 판단한적이 있으면 t, 없으면 f
    // visit: 방문한 적 없으면 f, 있으면 t
    public static boolean [] visit, finished;
    public static int [] graph;
    public static int cnt; // 팀인 사람의 명수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0) {
            int n = sc.nextInt();
            graph = new int [n+1];
            visit = new boolean[n+1];
            finished = new boolean[n+1];
            cnt = 0;

            for (int i = 1; i <= n ; i++) {
                graph[i] = sc.nextInt();
            }

            for (int i = 1; i <= n ; i++) {
                dfs(i);
            }
            System.out.println(n - cnt);
        }
    }
    public static void dfs(int v) {
        visit[v] = true;
        int next = graph[v];

        // 방문한 적 없다면 일단 탐색
        if (!visit[next]) {
            dfs(next);
        }
        // 재방문 했다면 loop이 발생된것이므로 cnt++해주며 팀인 사람을 센다
        else {
            if (!finished[next]) {
                cnt ++;
                while(next != v) {
                    cnt ++;
                    next = graph[next];
                }
                next = graph[next];
            }
        }
        finished[v] = true; // 팀원 여부 파악 완
    }
}
