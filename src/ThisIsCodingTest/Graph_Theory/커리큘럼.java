// topology sort 바로 적용!
// 문제에서 말하는 최소시간은 !!
// https://github.com/ndb796/python-for-coding-test/issues/17
// 위와 같이 두 선수과목을 동시에 듣는다고 했을 때, 
// 선수과목이 두개라면 두개를 모두 들어야 한다는 가정이므로 max를 사용하여 값을 구하는 것임

// 문제이해를 잘하자~~~~

import java.util.*;
import java.lang.*;

public class Main{
	public static int v;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static int[] indegree = new int [100001];
	public static int[] times = new int [100001];
	
	// 기본적인 topologySort와 다른 점
	// result가 저장하는 것은 수강시간!
	// result가 LL 형태가 아니라 배열임
	// 진입 차수가 0인 것부터 기준으로 거기에 연결된 노드의 result를 항상 최대로 업데이트
	// idx가 작은 것이 선수과목이 아니더라도, 진입차수가 0인 것부터 접근하고 그에 연결된 것의 
	// 값을 업데이트 하는 방식이므로 idx가 작은 것과 선수과목여부는 연관없음
	public static void topologySort(){
		// 기존 result는 add로 적용되나, 이번 경우는 순서대로 출력해야 하므로
		// c타입 배열을 사용하여 순서가 뒤섞이는 것을 막음
		int result[] = new int [501];
		
		// 처음에는 각 vertex의 시간으로만 초기화
		for (int i = 0; i <= v; i ++) {
			result[i] = times[i];
		}

		// indegree가 0인 vertex를 q에 삽입
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= v; i ++) {
			if (indegree[i] == 0)
				q.offer(i);
		}

		while(!q.isEmpty()) {
			// 큐에서 원소 꺼내기
			int now = q.poll();

			for (int i : graph.get(now)) {
				// 왜 max인지는 맨 위 주석 참고!
				result[i] = Math.max(result[i], result[now] + times[i]);
				// 해당 원소와 연결된 노드들의 진입차수에서 1을 빼기
				indegree[i]--;

				// 새롭게 진입차수가 0이 된 vertex를 큐에 삽입
				if (indegree[i] == 0)
					q.offer(i);
			}
		}

		for(int i = 1; i <= v; i ++) {
			System.out.println(result[i]);
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		v = sc.nextInt();
		
		for (int i = 0; i <= v; i ++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 1; i <= v; i++) {
			int x = sc.nextInt();
			times[i] = x;
			x = sc.nextInt();
			while(x != -1) {
				indegree[i] ++;
				graph.get(i).add(i);
				x = sc.nextInt();
			}
		}
		
		topologySort();
	}
	
}