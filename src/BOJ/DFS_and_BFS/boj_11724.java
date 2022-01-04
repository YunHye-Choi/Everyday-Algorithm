// 쉽게 풀었다~ no 시행착오~
// https://www.acmicpc.net/problem/11724

import java.util.*;

public class boj_11724 {
    public static ArrayList<Integer>[] graph;
    public static boolean[] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        visit = new boolean[n+1];
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for(int i = 1; i <= m ; i ++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            graph[start].add(end);
            graph[end].add(start);
        }

        int cnt = 0;
        for (int i =1; i <= n; i++) {
            if (!visit[i]) {
                dfs(i);
                cnt ++;
            }
        }

        System.out.println(cnt);
    }    

    public static void dfs(int v) {
        visit[v] = true;
        for(int i: graph[v]) {
            if (!visit[i]) {
                dfs(i);
            }
        }
    }
}
