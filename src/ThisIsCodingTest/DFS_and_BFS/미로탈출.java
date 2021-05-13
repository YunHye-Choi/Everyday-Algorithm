// 시간 내에 풀지 못함.
// 아래는 책 풀이
/* package whatever; // don't place package name! */

/* import java.util.*;

class Node(int x, int y) {
	private int x;
	private int y;
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX(){return x;}
	public int getY(){return y;}
}
public class Main
{
	public static int n = 5, m = 6;
	public static int[][] graph = new int [201][201];
	
    //                       상  하  좌  우
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	
	public static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		
		// 큐가 빌 때까지 반복하기
		while(!q.isEmpty()) {
			Node node = q.poll();
			x = node.getX();
			y = node.getY();
			
			// 현재위치 기준, 네가지 방향으로의 위치확인
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
                int ny = y + dy[i];

                // 미로찾기 공간을 벗어난 경우는 무시
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 벽인 경우 무시
                if (graph[nx][ny] == 0) continue;
                // 해당 노드를 처음 방문하는 경우(1)에만 최단거리 기록
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Node(nx, ny));
                }
			}
		}

        // 가장 오른쪽 아래에 저장된 최단거리 반환
        return graph[n-1][m-1];
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
        graph = {
            {1,0,1,0,1,0}, 
            {1,1,1,1,1,1},
            {0,0,0,0,0,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1}
        }
		System.out.println(bfs(0,0));
	}
} */

import java.util.*;

class Node {
    private int x;
    private int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
public class Main {
    public static Queue<Node> q = new LinkedList<>();
    public static int n = 5, m = 6;
    public static int[][] graph = {
        {1,0,1,0,1,0}, 
        {1,1,1,1,1,1},
        {0,0,0,0,0,1},
        {1,1,1,1,1,1},
        {1,1,1,1,1,1}
    };
    public static int bfs(int x, int y) {
        q.offer(new Node(x, y));

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            // 큐에서 꺼내오자
            Node node = q.poll();
            x = node.getX();
            y = node.getY();

            for (int i = 0; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // out of boundary
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) 
                continue;
                
                // monster
                if (graph[nx][ny] == 0)
                continue;
                
                //if (nx==0 && ny==0) continue; // 하든 안하든 상관없는 처리

                // first visit!
                if (graph[nx][ny] == 1) {
                    // 상하좌우 중 1인 아이는 1 더하여 큐에 넣자.
                    q.offer(new Node(nx, ny));
                    graph[nx][ny] += graph[x][y];
                }
            }
        }
        return graph[n-1][m-1];
    }
    
    public static void main(String[] args) {
        System.out.println(bfs(0,0));
    }
}