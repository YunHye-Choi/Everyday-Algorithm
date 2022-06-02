// https://www.acmicpc.net/problem/1167
// https://moonsbeen.tistory.com/101
// 위 블로그 풀이 완전히 이해하고 풀어보기

import java.util.*;
class Edge {
    int node;
    int weight;

    public Edge (int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}
public class boj_1167 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[n+1];
        Long max = Long.MIN_VALUE;
        for (int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < n+1; i++) {
            int num = sc.nextInt();
            while(true) {
                int node = sc.nextInt();
                if (node == -1) break;
                int weight = sc.nextInt();
                graph[num].add(new Edge(node, weight));
            }
        }
        for (int i = 1; i < n+1; i ++) {
            // leaf node들에 대해서만 계산
            if (graph[i].size() == 1) {
                Queue<Integer> q = new LinkedList<Integer>();
                boolean [] visit = new boolean [n+1];
                q.add(i);
                visit[i] = true;
                while(!q.isEmpty()) {
                    int num = q.poll();
                    
                }
            }
        }
    }
}
