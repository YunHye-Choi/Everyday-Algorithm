import java.util.*;
class Edge {
    int node;
    int cost;

    public Edge (int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}
public class boj_1967 {
    public static ArrayList<Edge>[] graph;
    public static boolean visit[]; 
    public static int mNode = 0;
    public static int mCost = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        graph = new ArrayList[n+1];
        
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int c = sc.nextInt();
            graph[n1].add(new Edge(n2, c));
            graph[n2].add(new Edge(n1, c));
        }

        visit = new boolean[n+1];
        dfs(1, 0);

        visit = new boolean[n+1];
        dfs(mNode, 0);

        System.out.println(mCost);

    }

    public static void dfs(int node, int cost) {
        if (mCost < cost) {
            mCost = cost;
            mNode = node;
        }
        visit[node] = true;
        for (Edge e : graph[node]) {
            if (!visit[e.node]) {
                dfs(e.node, e.cost + cost);
            }
        }
    }
}
