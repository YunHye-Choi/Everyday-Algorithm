import java.util.*;

public class boj_11403 {
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[n];
        boolean visit[];
        for (int i = 0; i < n; i ++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++){
                if (sc.nextInt() == 1) {
                    graph[i].add(j);
                }
            }
        }
        int[][]ans = new int[n][n];
        for (int start = 0; start < n; start ++) {
            for (int end = 0; end < n; end ++){
                Queue<Integer> q = new LinkedList<>();
                visit = new boolean[n];
                q.add(start);
                while(!q.isEmpty()){
                    int k = q.poll();
                    visit[k] = true;
                    for (int tmp : graph[k]){
                        if (tmp == end){
                            ans[start][end] = 1;
                            break;
                        }
                        if (!visit[tmp])
                            q.add(tmp);
                    }
                    if (ans[start][end] == 1) break;
                }
            }
        }
        System.out.println("------------");
        for (int i = 0; i < n; i ++){
            for (int j = 0; j < n;j ++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

    }
}