import java.util.*;
class Point {
    int x;
    int y;
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class boj_2178 {
    public static int n, m;

    public static int [][] map;
    public static boolean [][] visit;

    public static Queue<Point> q;

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0}; 

    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        sc.nextLine();

        map = new int[n][m];
        visit = new boolean[n][m];

        q = new LinkedList<Point>();

        for (int i = 0; i < n; i ++) {
            String tmp = sc.nextLine();
            char[] arr = tmp.toCharArray();
            int j = 0;
            for (char c : arr) {
                map[i][j++] = c - '0';
            }
        }

        q.add(new Point (0, 0));
        visit[0][0] = true;

        bfs();

        System.out.println(map[n-1][m-1]);
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i ++) {
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (map[ny][nx] != 0 && !visit[ny][nx]) {
                        q.add(new Point(nx, ny));
                        map[ny][nx] = map[p.y][p.x] + 1;
                        visit[ny][nx] = true;
                    }
                    
                }
            }
        }
    }
}
