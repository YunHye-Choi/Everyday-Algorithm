// https://www.acmicpc.net/problem/11403
import java.util.*;
public class boj_11403 {
    public static boolean[] visit;
    public static int[][] ans;
    public static ArrayList<Integer>[] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ans = new int[n][n];
        graph = new ArrayList[n];
        
        for (int i = 0; i < n; i ++) {
            graph[i] = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                if (num == 1) {
                    graph[i].add(j);
                }
            }
        }
        
        // DFS 사용하여 해결하면 됨!
        // ans를 순회
        // graph가 1인 경우
        for (int i = 0; i < n; i ++) {
            visit = new boolean[n];
            for (int j = 0; j < n; j++) {
                if (dfs(i, j)) ans[i][j] = 1;
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static boolean dfs(int start, int end) {
        visit[start] = true;
        for (int num: graph[start]){
            if (num == end) return true;
            if (!visit[num]) {
                dfs(num, end);
            }
        }
        return false;
    }
}
