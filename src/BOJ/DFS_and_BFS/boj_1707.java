// https://www.acmicpc.net/problem/1707
// 이분 그래프: 인접한 모든 노드 서로 다른 색으로 칠할 때, 총 사용 색깔이 2개인 그래프 
// 비연결 그래프도 이분그래프에 포함될 수 있다는 사실
// 이분그래프 탐색에는 BFS 를 이용한다! 는 사실
// 풀이: https://toastfactory.tistory.com/115
import java.util.*;
public class boj_1707 {
    public static ArrayList<Integer>[] graph;
    public static int [] color;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        while(k-- != 0) {
            int v = sc.nextInt();
            int e = sc.nextInt();
            graph = new ArrayList[v+1];
            color = new int[v+1];
            for (int i = 1; i <= v; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 1; i <= e;i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();

                graph[start].add(end);
                graph[end].add(start);
            }

            String result = "YES";
            // loop돌면서 색깔어레이에 대상노드 1(2), 인접노드 2(1) 저장
            for (int j = 1; j <= v; j ++) { // 이어져 있지 않은 정점을 대비해서 모든 정점에 대해 검사
                if(color[j] == 0) {
                    color[j] = 1;

                    Queue<Integer> q = new LinkedList<>();
                    q.add(j);
                    
                    while(!q.isEmpty()) {
                        int n = q.poll();
                        for (int i: graph[n]) {
                            if (color[i] == 0) {
                                if (color[n] == 1)
                                    color[i] = 2;
                                else if (color[n] == 2)
                                    color[i] = 1;
                                q.add(i);
                            } else if (color[i] == color[n] ) {
                                result = "NO";
                                break;
                            }
                        }
                    if (result.equals("NO")) break;
                    }
                }
            }
            System.out.println(result);
        }
     }
}
