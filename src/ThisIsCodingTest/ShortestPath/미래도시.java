/* package whatever; // don't place package name! */
/*
입력
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5
*/
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	// n은 노드개수, m은 엣지개수, x는 목적지 노드, k는 거쳐가는 노드
	public static int n, m, x, k;
	
	public static final int INF = (int)1e9;
	
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner (System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		int[][] graph = new int[n+1][n+1];
		
		for (int a = 1; a <= n; a++) {
			for (int b = 1; b <= n; b++) {
				graph[a][b] = INF;
			}
		}
		
		for (int a = 1; a <= n; a ++) {
			graph[a][a] = 0;
		}
		
		for (int i = 0; i < m; i++ ) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		x = sc.nextInt();
		k = sc.nextInt();
		
		// Floyd-Warshall
		for (int i = 1; i <= n; i++) {
			for (int a = 1; a <= n; a++) {
				for (int b = 1; b <= n; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[i][b]);
				}
			}
		}
		
		int ans = graph[1][k] + graph[k][x];
		if (ans >= INF) ans = -1;
		System.out.println(ans);
	}
}