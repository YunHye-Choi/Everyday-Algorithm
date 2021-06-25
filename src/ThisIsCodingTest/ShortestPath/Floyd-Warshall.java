/* package whatever; // don't place package name! */

/*
입력
4
7
1 2 4
1 4 6
2 1 3
2 3 7
3 1 5
3 4 4
4 3 2
*/
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static final int INF = (int)1e9;
	
	// node개수: n, edge개수: m, 거쳐갈 노드: x, 최종 목적지 노드: k
	public static int n, m;
	
	public static int[][] graph = new int[101][101];
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for (int i = 0; i < 101; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		for (int a = 1; a <= n; a ++) {
			for (int b = 1; b <=n ; b ++) {
				if (a == b) graph[a][b] = 0;
			}
		}
		
		// 각 간선에 대한 정보를 입력받아, 그 값으로 초기화
		for (int i = 0; i < m; i ++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			graph[a][b] = c;
		}
		
		// 점화식에 따라 Floyd-Warshall 알고리즘 수행
		for (int k = 1; k <= n; k ++) {
			for (int a = 1; a <= n; a++) {
				for (int b = 1; b <= n; b ++) {
					graph[a][b] = Math.min (graph[a][b] , graph[a][k] + graph[k][b]);
				}
			}
		}
		
		// 수행된 결과를 출력
		for (int a = 1; a <= n; a++) {
			for (int b = 1; b <= n; b++) {
				if (graph[a][b] == INF) {
					System.out.print("Infinity ");
				} 
				else {
					System.out.print(graph[a][b] + " ");
				}
				
			}
			System.out.println();
		}
	}
}