// https://www.acmicpc.net/problem/7576
import java.util.*;
public class boj_7576 {
    public static int m, n;
    public static int [][] map;
    public static boolean [][] visit;
    public static int [] dx = {0, 0, -1, 1};
    public static int [] dy = {1, -1, 0, 0};
    public static int ans;
    
    public static void main(String [] args) {
        Scanner sc = new Scanner (System.in);
        m = sc.nextInt(); // x
        n = sc.nextInt(); // y
        ans = 0;
        map = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n ; i ++) {
            for (int j = 0; j < m; j ++) {  
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i ++) { // y
            for (int j = 0; j < m; j++) { // x
                if (!visit[i][j] && map[i][j] == 1) {
                    bfs(j, i);
                }
            }
        }
    }
    public static void bfs(int x, int y){
        visit[y][x] = true;

        Queue<Integer[]> q = new LinkedList<>();

        for (int i = 0; i < 4; i ++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                if (map[ny][nx] == 0) {
                    Integer[] temp = {nx, ny};
                    q.add(temp);
                    ans ++;
                }
            }
        }
        while (!q.isEmpty()) {
            
        }
    }
}
