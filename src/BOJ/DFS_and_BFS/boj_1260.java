import java.util.*;
public class boj_1260 {
    public static ArrayList<Integer>[] graph;
    public static boolean [] visit;
    public static void main(String args[]) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        graph = new ArrayList[n+1];
        visit = new boolean[n+1];
        for (int i = 1; i <= n; i ++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m ; i ++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            // 방향이 있다고 안했으므로 양쪽다 연결!
            graph[start].add(end);
            graph[end].add(start);
        }

        // 오름차순으로 정렬하여 무조건 낮은 숫자부터 방문하도록 설정
        for (int i = 1; i <= n; i ++) {
            Collections.sort(graph[i]);
        }
        dfs(v);
        visit = new boolean[n+1];
        System.out.println();
        bfs(v);

    }
    private static void dfs(int v) {
        visit[v] = true;
        System.out.print(v + " ");

        for (int i : graph[v]) {
            if (!visit[i]) {
                dfs(i);
            }
        }
    }
    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();

        q.add(v);
        visit[v] = true;
        System.out.print(v + " ");

        while(!q.isEmpty()) {
            int n = q.poll();
            for (int i : graph[n]){
                if (!visit[i]) {
                    q.add(i);
                    visit[i] = true;
                    System.out.print(i + " ");
                }
            }
            
        }
    }
}
