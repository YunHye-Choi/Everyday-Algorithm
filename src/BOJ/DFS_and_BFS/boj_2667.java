// https://www.acmicpc.net/problem/2667
// 블로그 풀이: https://ballpython.tistory.com/7
import java.util.*;
public class boj_2667 {
    static int [][] map;
    static boolean [][] visit;
    static int n, cnt;
    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {-1, 1, 0, 0};
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        map = new int [n][n];
        visit = new boolean [n][n];
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < n ; j ++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
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

    static void find(int x, int y) {
        visit[x][y] = true;

        // 상하좌우 검사
        for (int i = 0; i < 4; i ++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < n && nextX >= 0 && nextY < n && nextY >= 0) {
                if (map[nextX][nextY] == 1 && !visit[nextX][nextY]) {
                    find(nextX, nextY);
                    cnt ++;
                }
            }
        }
    }
}
