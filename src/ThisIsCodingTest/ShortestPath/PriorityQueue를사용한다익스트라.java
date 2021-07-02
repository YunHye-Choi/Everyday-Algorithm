/* package whatever; // don't place package name! */
/*
입력예시
6 11
1
1 2 2 
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2
 */
import java.util.*;
import java.lang.*;
import java.io.*;

class Node implements Comparable<Node> {
	private int index;
	private int distance;
	
	public Node (int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public int getDistance() {
		return this.distance;
	}
	
	// distance를 기준으로 비교
	@Override
    public int compareTo(Node other) {
        if (this.distance < other.distance)
            return -1;
        
        return 1;
    }
}

public class Main
{
	// 10억을 무한으로 지정
	public static final int INF = (int)1e9;
	
	// 노드의 개수(n), 엣지의 개수(m), 시작 노드번호(start)
	public static int n, m, start;
	
	// 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	
	// 최단거리 테이블 만들기
	public static int [] d = new int [100001];
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		d[start] = 0; // 시작~시작노드의 거리는 0
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int dist = node.getDistance();
			int now = node.getIndex();
			
			// 현재 노드가 이미 처리된 적이 있는 노드라면 무시
			if (d[now] < dist) continue;
			
			// 현재 노드와 연결된 다른 인접한 노드들을 확인
			for (int i = 0; i < graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				// 현재(now)노드를 거쳐서, 다른 노드(i)로 이동하는 거리(cost)가
				// 기존에 저장되었던 거리(d[...])보다더 짧은 경우
				if (cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost; // 최단거리 업데이트
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost)); // pq에 노드 삽입
				}
			}
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner (System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();
		
		for (int i = 0; i <=n ; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();//시작노드
			int b = sc.nextInt();//끝노드
			int c = sc.nextInt();//거리(비용)
			
			graph.get(a).add(new Node(b, c));
		}
		
		Arrays.fill(d, INF);
		
		dijkstra(start);
		
		for (int i = 1; i <= n; i ++) {
			// 도달할 수 없는 경우, 무한이라고 출력
			if (d[i] == INF) {
				System.out.println("Infinity");
			}
			// 도달할 수 있는 경우 거리를 출력
			else {
				System.out.println(d[i]);
			}
		}
	}
}