// https://www.acmicpc.net/problem/1167
// https://moonsbeen.tistory.com/101
// [1] dfs 풀이

import java.util.*;
class Edge {
    int node;
    int cost;

    public Edge (int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}
public class boj_1167_dfs {
    public static ArrayList<Edge>[] graph;
    public static int maxCost = 0;
    public static int maxNode = 0;
    public static boolean[] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        graph = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < n+1; i++) {
            int num = sc.nextInt();
            while(true) {
                int node = sc.nextInt();
                if (node == -1) break;
                int cost = sc.nextInt();
                graph[num].add(new Edge(node, cost));
            }
        }

        // 임의의 node 1에 대해 dfs로 가장 먼 노드 a를 찾는다
        visit = new boolean[n+1];
        dfs(1, 0);

        // a로부터 가장 먼 노드를 찾아 정답을 구한다
        visit = new boolean[n+1];
        dfs(maxNode, 0);

        System.out.println(maxCost);
        
    }
    public static void dfs (int node, int cost) {
        if (maxCost < cost) {
            maxCost = cost;
            maxNode = node;
        }
        visit[node] = true;
        for (Edge e : graph[node]) {
            if (!visit[e.node]) {
                dfs(e.node, e.cost + cost);
            }
        }
    }

}
