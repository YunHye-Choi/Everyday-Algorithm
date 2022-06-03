// bfs로 풀어보기!

import java.util.*;
class Edge {
    int node;
    int cost;

    public Edge (int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}
public class boj_1167_bfs {
    public static ArrayList<Edge>[] graph;
    public static boolean[] visit;
    public static int maxNode = 0;
    public static int maxCost = 0;
    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        graph = new ArrayList[n+1];
        for (int i = 0; i <=n ;i ++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i ++) {
            int num = sc.nextInt();
            while(true) {
                int node = sc.nextInt();
                if (node == -1) break;
                int cost = sc.nextInt();
                graph[num].add(new Edge(node, cost));
            }
        }
        
        // 임의의 node 1로부터 최장거리와 최장 노드 a 구하기 (bfs)
        Queue<Edge> q = new LinkedList<>();
        visit = new boolean[n+1];
        q.add(new Edge(1, 0));
        visit[1] = true;
        while (!q.isEmpty()) {
            Edge e = q.poll();
            if (maxCost < e.cost) {
                maxCost = e.cost;
                maxNode = e.node;
            }
            for (Edge tmpE : graph[e.node]) {
                if (!visit[tmpE.node]) {
                    q.add(new Edge(tmpE.node, tmpE.cost + e.cost));
                    visit[tmpE.node] = true;
                }
            } 
        }

        // a로부터 최장거리 구하기 (bfs)
        
        q = new LinkedList<>();
        visit = new boolean[n+1];
        visit[maxNode] = true;
        q.add(new Edge(maxNode, 0));
        while (!q.isEmpty()) {
            Edge e = q.poll();
            if (maxCost < e.cost) {
                maxCost = e.cost;
                maxNode = e.node;
            }
            for (Edge tmpE : graph[e.node]) {
                if (!visit[tmpE.node]) {
                    q.add(new Edge(tmpE.node, tmpE.cost + e.cost));
                    visit[tmpE.node] = true;
                }
            } 
        }

        System.out.println(maxCost);    
    }
}