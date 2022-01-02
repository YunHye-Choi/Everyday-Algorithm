// 아니야!!!!위상정렬이야!!!
// 위상정렬 : 방향성이 있으면서 사이클은 없는 그래프의 정렬
// https://www.acmicpc.net/problem/1005

import java.util.*;
import java.lang.Math;

public class boj_1005 {
    public static int n, k, w;
    public static int [] time, indegree, result;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i ++) {
            n = sc.nextInt();//건물개수
            k = sc.nextInt();//규칙개수
           
            time = new int [n+1];
            indegree = new int [n+1];
            result = new int [n+1];

            for (int j = 1; j < n+1; j ++) {
                time[j] = sc.nextInt();
            }
            /* 1. ArrayList<Integer>[] */
            ArrayList<Integer>[] link = new ArrayList[n+1];

            for (int j = 1; j < n+1; j ++) {
                link[j] = new ArrayList<>();
            }

            /* 2. 인접리스트에 그래프 만들기 */
            for (int j = 0; j < k; j ++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                link[start].add(end);
                indegree[end] ++; // indegree 노드 수 세기 
            }
            
            w = sc.nextInt(); // target (짓고자 하는 건물)

            // 위상정렬 시작
            Queue<Integer> queue = new LinkedList<>();
            
            /* 3. indegree 0인 노드찾아 enqueue */
            for (int j = 1; j <= n; j ++) {
                if (indegree[j] == 0) {
                    queue.add(j);
                    result[j] = time[j];
                }
            }
            /* 4. dequeue, enqueue하며 result값 업데이트 */
            while(!queue.isEmpty()) {
                /* (1) dequeue한 값을 start로 둔다 */
                int start = queue.poll();
                /* (2) link[start]를 순회하며 end로 둔다 */
                for (int end : link[start]) {
                    /* (2-1) result[end]값을 result[end]와 result[start] + time[end] 값 중 더 큰 값으로 update한다. */
                    result[end] = Math.max(result[end], result[start] + time[end]);
                    /* (2-2) -- indegree[end]가 0이면 enqueue */
                    if (--indegree[end] == 0)
                        queue.add(end);
                }
            }
            System.out.println(result[w]);
        }
    }
}
