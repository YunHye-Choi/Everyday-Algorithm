// https://www.acmicpc.net/problem/7576
// 풀이참고: https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-7576%EB%B2%88-%ED%86%A0%EB%A7%88%ED%86%A0-%EC%9E%90%EB%B0%94Java

import java.util.*;

class Tomato {
    int x;
    int y;

    public Tomato (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class boj_7576 {
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};

    public static int[][] map;
    public static Queue<Tomato> q;

    public static int m, n; // m:y, n:x

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        map = new int [n][m];
        q = new LinkedList<>();

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 1) {
                    q.add(new Tomato(i, j));
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs () {
        while (!q.isEmpty()) {
            Tomato t = q.poll();
            for (int i = 0; i < 4; i ++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (map[nx][ny] == 0) {
                        q.add(new Tomato(nx, ny));
                        map[nx][ny] = map[t.x][t.y] + 1;
                    }
                }
            }
        }
        
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (map[i][j] == 0) return -1;
                else result = Math.max(map[i][j], result);
            }
        }

        return (result-1);
    }
}