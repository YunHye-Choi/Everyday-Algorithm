// https://www.acmicpc.net/problem/2667
// 블로그 풀이: https://ballpython.tistory.com/7
import java.util.*;
public class boj_2667 {
    public static int[][] map;
    public static boolean[][] visit;
    public static int [] dx = {0, 0, -1, 1};
    public static int [] dy = {1, -1, 0, 0};
    public static int cnt, n;
    public static ArrayList<Integer> ans;
    public static void main(String [] args) {
        Scanner sc = new Scanner (System.in);
        n = Integer.parseInt(sc.nextLine());
        map = new int[n][n];
        visit = new boolean[n][n];
        ans = new ArrayList<>();

        for (int i = 0; i < n; i ++) {
            String str = sc.nextLine();
            for (int j = 0; j < n; j ++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        for (int i = 0;i<n;i++) {
            for (int j = 0; j < n; j ++) {
               if (map[i][j] == 1 && !visit[i][j]){
                   cnt = 1;
                   find(i, j);
                   ans.add(cnt);
               }
            }
        }
        Collections.sort(ans);

        System.out.println(ans.size());
        
        for (int tmp:ans) {
            System.out.println(tmp);
        }
        
    }

    public static int find(int x, int y) {
        visit[x][y] = true;
        // 상하좌우 검사
        for (int i = 0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // nx, ny가 map범위 안이면
            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                // 연결되어 있고, 아직 방문안했으면
                if (map[nx][ny] == 1 && !visit[nx][ny]) {
                    find(nx, ny);
                    cnt ++;
                }
            }
        }
        return cnt;
    }
}
