/* package whatever; // don't place package name! */

import java.util.ArrayList;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	// 오늘의 지식: boolean형의 초기값은 false이다.
	public static boolean visited[] = new boolean[9];
    // 이차원 어레이리스트로 인접 리스트 구현!! 직관적이고 짜기 쉬우니 이렇게 하자.
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static void dfs(int x) {
		// 방문했다
		visited[x] = true;
		System.out.print(x+ " ");
		// 방문 처리 해주고 인접 중 방문안한거 있으면 꺼내와!
		for (int i = 0; i < graph.get(x).size(); i++) {
			Integer y = graph.get(x).get(i);
			if (!visited[y]) {
				dfs(y);
			}
		}
	}
	public static void main(String[]args) {
		for (int i = 0; i < 9; i++) {
			graph.add(new ArrayList <Integer>());
		}
		
		// 정보 초기화
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
        
        dfs(1); // 1번 노드부터 탐색~
	}
}