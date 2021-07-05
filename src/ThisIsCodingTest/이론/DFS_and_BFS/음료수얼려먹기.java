/* package whatever; // don't place package name! */
// 30분 내로 못풀었음
// 처음 30분 동안의 내 접근은..블로그에 정리 << 확실히 쓰면서 하는게 수월함
// 아래는 책 풀이
// 얼음 틀을 그래프로 생각하면, 상하좌우가 연결된 그래프로 볼 수 있음.
// 1. 특정한 지점의 주변 상하좌우를 살펴본 뒤에 주변 지점 중에서 값이 0이면서 아직 방문하지 않은 점을 방문
// -> 주어진 값 자체를 방문 여부로 활용!! (visited[x]대신 사용)
// 2. 방문한 지점에서 다시 상하좌우 살펴보면서 방문 진행하면, 연결된 모든 지점을 방문할 수 있다.
// 3. 1~2 반복하며 방문안한 지점의 수를 센다 (?)아직 이해 x

import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
/* class Ideone
{
	public static int n, m;
	public static int [][] graph = new int [1000][1000];// 0 혹은 1을 저장, visited역할!
 
	// dfs로 특정 노드를 방문하고 연결된 모든 노드들도 방문
	public static boolean dfs(int x, int y) {
		// 주어진 범위를 벗어나는 경우에는 즉시 종료
		if (x <= -1 || x >= n || y <= -1 || y >= m){
			return false;
		}
 
		// 현재 노드를 아직 방문하지 않은 경우
		if (graph[x][y] == 0) {
			// 해당 노드 방문 처리
			graph[x][y] = 1;

			// 상하좌우의 노드도 탐색하기
			dfs(x-1, y); // 상
			dfs(x, y-1); // 좌
			dfs(x+1, y); // 하
			dfs(x, y+1); // 우
			return true;
		}
		return false;
	}
 
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
 
		n = sc.nextInt ();
		m = sc.nextInt ();
		sc.nextLine(); // 버퍼 지우기
 
		// 2차원 리스트의 맵 정보 입력받기
		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < m; j ++) {
				graph[i][j] = str.charAt(j) - '0'; // 문자를 숫자로 저장
			}
		}
 
		// 모든 노드(위치)에 대해 음료수 채우기
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (dfs(i, j)) {
					result ++; // dfs로 탐색이 성공했다면~ 아이스크림 추가!
				}
			}
		}
		System.out.println(result);
	}
}
 */
// 풀이 리뷰:
// 이 풀이의 핵심은 방문여부와 칸이 채워진 것의여부를 같게 보는 것이다.
// 이 문제 풀이과정 복기해보면
// 1. 입, 출력 처리, graph[][] 초기화
// 2. 모든 칸을 이중 반복문으로 순회하며 dfs(row, col)호출
// 3. dfs()에서는 범위 벗어난 경우에 대해 예외처리 해준 다음
//    graph[][]가 0 이라면 해당 노드의 상하좌우에 대해 dfs()재귀적 실행, 이후 return true;
//    여기서, 어차피 상하좌우는 연결된 노드이므로 따로 자료구조 사용x한 점이 인상적.
//    graph[][]가 1이라면 return false
// 4. dfs()가 true를 반환한다면 (빈칸이었을 때 해당 노드와 연결된 노드를 모두 방문했다면) ans ++;
//    여기서 포인트! 방문 하지 않은 노드를 받았을 때 true를 반환!!

// 내가 다시 풀어보자!

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class 음료수얼려먹기
{
	public static int[][] graph  = {
		{0, 0, 1, 1, 0},
		{0, 0, 0, 1, 1},
		{1, 1, 1, 1, 1},
		{0, 0, 0, 0, 0}
	};
	
	public static int n = 4, m = 5;
	
	public static boolean dfs(int x, int y) {
		if (x <= -1||x >= n|| y <= -1 || y >= m) {
			return false;
		}
		
		// 음료수 채우기~
		if(graph[x][y] == 0) {
			graph[x][y] = 1;
			dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
			return true;
		}
		return false;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		int solution = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (dfs(i, j)) solution ++;
			}
		}
		System.out.println(solution);
	}
}

