// https://www.acmicpc.net/problem/1012
// DFS를 통해 사이클의 개수를 세는 문제
// 문제는 내가 DFS구현을 할줄모름
// 오늘의 목표: 풀이 보면서 정답코드와 DFS 외우자

import java.util.*;

public class boj_1012 {
	public static int cab[][];
    public static boolean visit[][];
    public static int m, n, k;
    // 상하좌우
    public static int dr[] = {-1, 1, 0, 0};
    public static int dc[] = {0, 0, -1, 1};
    public static void main(String args[]) {
    	
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int cnt = 0;
        for (int i = 0; i < t; i ++) {
        	m = sc.nextInt();
	        n = sc.nextInt();
	        k = sc.nextInt();
	        cab = new int [m][n];
	        visit = new boolean [m][n];
        	for (int j = 0; j < k; j ++) {
	        	int x = sc.nextInt();
	        	int y = sc.nextInt();
	        	cab[x][y] = 1;
        	}
        	cnt = 0; // 구역 (사이클) 수
        	for (int r = 0; r < m; r ++) {
        		for(int c = 0; c < n; c ++) {
        			// 배추가 있으면 dfs탐색
        			if (cab[r][c] == 1 && !visit[r][c]) {
        				dfs(r, c);
        				cnt ++;
        			}
        		}
        	}
        	System.out.println(cnt);
        }
        
        
    }
    
    public static void dfs(int r, int c) {
    	visit[r][c] = true;
    	
    	// 상하좌우 인덱스 더하기
    	for(int i = 0; i < 4; i ++) {
    		int nr = r + dr[i];
    		int nc = c + dc[i];
    		// 범위 내에 있으면
    		if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
    			// 배추 있고 방문한적 없는지
    			if (cab[nr][nc] == 1 && !visit[nr][nc]) {
    				dfs(nr, nc);
    			}
    		}
    	}
    }
}