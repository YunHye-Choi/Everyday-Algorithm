// https://www.acmicpc.net/problem/2178
// 풀이 참고: https://dhbang.tistory.com/5
/**
 * 늘 헷갈리는 이차원 배열 && x, y && m, n 기억하자
 * - 행, 열 ==> 이차원배열[행 개수][열 개수]
 * - x, y ==> 이차원배열[y][x]
 * - m, n (가로 m, 세로 n) ==> 이차원배열[n][m]
 * */

import java.util.*;
class Point{
    int x;
    int y;

    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class boj_2178{
    public static int dx[] = {0, 0, -1, 1};
    public static int dy[] = {-1, 1, 0, 0};

    public static int n, m;
    public static int[][] map;
    public static boolean [][] visit;

    public static Queue<Point> q;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 행 개수 (==열 길이)
        m = sc.nextInt(); // 열 개수 (==행 길이)
        
        sc.nextLine();
        map = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            char[] temp = str.toCharArray();
            for (int j = 0; j < m; j ++) {
                map[i][j] = temp[j] - '0';
            }
        }

        q = new LinkedList<>();
        q.add(new Point(0,0));
        visit[0][0] = true;

        bfs();
        System.out.println(map[n-1][m-1]);

    }
    public static void bfs(){
        while(!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 4; i ++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >=0 && nx < m && ny >=0 && ny < n) {
                    if (!visit[ny][nx] && map[ny][nx] == 1) {
                        map[ny][nx] += map[y][x];
                        q.add(new Point(nx, ny));
                        visit[ny][nx] = true;
                    }
                }
            }
        }
    }
}