//  https://www.acmicpc.net/problem/11725
// 진짜 트리 구현하는 문제 아님
// 그래프를 이용해서 해결해야함 
// 참고: https://ilmiodiario.tistory.com/142
// 아무리 트리 구조라 해도 결국 그래프다.
// 그래프는 결국 인접리스트 형태!
// 그래프란건 결국 BFS, DFS를 모두 사용할 수 있다는 의미다.
// root부터 시작하면 중복되거나 순서가 바뀌는 것은 걱정하지 않아도 된다는 것 또한 포인트!
import java.util.*;
public class boj_11725 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        List<Integer>[] graph = new ArrayList[n+1];
        boolean visit[] = new boolean [n+1];

        // 연결리스트에 연결 정보 저장
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i ++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        // BFS로 root의 자식부터 시작하여 모든 node를 탐색
        // 그 와중에 방문하지 않았던 노드는 아직 부모를 밝혀내지 못한 것이므로
        // 정답 배열에 부모 노드 추가
        // 이 방법을 사용하면, 순서에 구애받지 않고 저장하면서도 이미 방문한 노드는 방문하지 않고,
        // root부터 시작하기 때문에 방향성도 보장된다
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;
        int ans[] = new int[n+1];
        while(!q.isEmpty()) {
            Integer num = q.poll();
            for(int i : graph[num]) {
                if (!visit[i] ) {
                    visit[i] = true;
                    ans[i] = num;
                    q.add(i);
                }
            }
        }

        for (int i = 2; i < n+1; i ++) {
            System.out.println(ans[i]);
        }
    }
}