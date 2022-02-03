// https://www.acmicpc.net/problem/4963
import java.util.*;
public class boj_4963 {
    public static boolean[][] visit;
    public static int[][] map;
    public static int w, h;
    // ↑ ↓ ← → ↖ ↗ ↙ ↘ 
    public static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    public static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        
        w = sc.nextInt();
        h = sc.nextInt();
        while (true) {
            if ((w == 0 && h == 0)) break;

            map = new int[w][h];
            visit = new boolean[w][h];
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            int ans = 0;
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++){
                    if (map[i][j] == 1 && !visit[i][j]) {
                        dfs(i, j);
                        ans ++;
                    }

                }
            }
            System.out.println(ans);

            w = sc.nextInt();
            h = sc.nextInt();
        }
    }

    public static void dfs (int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < w && ny >= 0 && ny < h) {
                if (map[nx][ny] == 1 && !visit[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
