/* package whatever; // don't place package name! */
// bfs연습
import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static boolean visited[] = new boolean[9];
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	//BFS함수 정의
	public static void bfs (int start) {
		Queue<Integer> q = new LinkedList<> ();
        // 큐에 삽입 직후 방문처리
		q.offer(start);
		visited[start] = true;
		
		// 큐가 빌 때까지 반복
		while(!q.isEmpty()) {
			// 큐에서 하나의 원소를 뽑아 출력
			int x = q.poll();
			System.out.print(x + " ");
			// 해당원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입, 방문처리
			for (int i = 0; i < graph.get(x).size(); i++) {
				int y = graph.get(x).get(i);
				if (!visited[y]) {
					q.offer(y);
					visited[y] = true;
				}
			}
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		// 그래프 초기화
		for (int i = 0; i < 9; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		// 노드 1에 연결된 노드 정보 저장
		graph.get(1).add(2);
		graph.get(1).add(3);
		graph.get(1).add(8);
		
		// 노드 2에 연결된 노드 정보 저장
		graph.get(2).add(1);
		graph.get(2).add(7);
		
		// 노드 3에 연결된 노드 정보 저장
		graph.get(3).add(1);
		graph.get(3).add(4);
		graph.get(3).add(5);
		
		// 노드 4에 연결된 노드 정보 저장 
        graph.get(4).add(3);
        graph.get(4).add(5);
        
        // 노드 5에 연결된 노드 정보 저장 
        graph.get(5).add(3);
        graph.get(5).add(4);
        
        // 노드 6에 연결된 노드 정보 저장 
        graph.get(6).add(7);
        
        // 노드 7에 연결된 노드 정보 저장 
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);
        
        // 노드 8에 연결된 노드 정보 저장 
        graph.get(8).add(1);
        graph.get(8).add(7);
        
        bfs(1);
	}
}