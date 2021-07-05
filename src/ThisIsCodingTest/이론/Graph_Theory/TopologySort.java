import java.util.*;

public class Main {
	public static int v, e;
	public static int [] indegree = new int [100001];
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	public static void topologySort() {
		ArrayList<Integer> result = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= v; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			result.add(now);
			for (int i : graph.get(now)) {
				indegree[i] --;
				if (indegree[i] == 0) {
					q.offer(i);
				}
			}
		}
        
		
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		v = sc.nextInt();
		e = sc.nextInt();
		
		// 앞에 빈 ArrayList를 추가해서 index를 vertex번호로 쓸 수 있도록 하는 게 포인트!
		for (int i = 0; i <= v; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		
		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);
			indegree[b] ++;
		}
		
		topologySort();
	}
}