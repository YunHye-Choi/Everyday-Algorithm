// https://www.acmicpc.net/problem/2146
// 풀이 참고 https://devowen.com/317
// 힌트 얻은 부분: 아이디어는 비슷하게 생각해냄! 다만 distance를 저장하는 arr를 따로 만들 생각을 못함 ㅠㅠ
// 다음부터는 안보고 더 고민하자!
import java.util.*;
class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class boj_2146 {
    public static int[][]init, team, dist;
    public static Queue<Point> q;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        init = new int[n][n];
        team = new int[n][n];
        dist = new int[n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                init[i][j] = sc.nextInt();
            }
        }
        // 같은 섬 데이터를 team에 저장하고, 
        // 섬은 dist에 0, 바다는 dist에 -1저장!
        q = new LinkedList<Point>();
        int teamNum = 1;

        for (int i = 0 ; i < n; i ++) {
            for (int j = 0; j < n ; j ++ ) {
                dist[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (team[i][j] ==0 && init[i][j] == 1) {
                    q.add(new Point(j, i));
                    team[i][j] = teamNum++;
                    dist[i][j] = 0;
                    while(!q.isEmpty()) {
                        Point p = q.poll();
                        for (int k = 0; k < 4; k ++) {
                            int nx = p.x + dx[k];
                            int ny = p.y + dy[k];

                            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                                if (team[ny][nx] ==0 && init[ny][nx] == 1) {
                                    q.add(new Point(nx, ny));
                                    dist[ny][nx] = 0;
                                    team[ny][nx] = teamNum;
                                }
                            }
                        }
                    }
                }
            }
        }

        q = new LinkedList<Point>();

        // 일단 섬을 구성하는 애들을 다 queue에 추가!
        for (int i = 0; i < n ; i ++) {
            for (int j = 0; j < n; j ++) {
                if (init[i][j] ==1) {
                    q.add(new Point(i, j));
                }
            }
        }

        // queue를 탐색하며 주변에 바다가 있는 애들에
        // team과 dist를 갱신해주며 순회
        while(!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i ++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (dist[ny][nx] == -1) {
                        team[ny][nx] = team[p.y][p.x];
                        dist[ny][nx] = dist[p.y][p.x];
                    }
                }
            }
        }

        
        // 이후, 인접한 dist에서 두 칸의 합 중 최소를 찾으면 됨!
        // (완전탐색, 상하좌우 네 방향에 대해 비교, 및 result값 최솟값으로 갱신)

        sc.close();
    }
}
