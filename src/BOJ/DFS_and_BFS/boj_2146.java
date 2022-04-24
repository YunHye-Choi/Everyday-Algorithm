// https://www.acmicpc.net/problem/2146
// 풀이 참고 https://devowen.com/317
// 힌트 얻은 부분: 아이디어는 비슷하게 생각해냄! 다만 distance를 저장하는 arr를 따로 만들 생각을 못함 ㅠㅠ
// 다음부터는 안보고 더 고민하자!
/**
 * 전반적인 풀이
 * 처음 데이터를 init[][]에 일단 저장
 * bfs이용, team[][]에 각 섬을 구분하는 섬 구분코드를 저장
 * dist[][]에 섬부분 0, 바다 -1 로 저장한다
 * 이후, 완전 탐색을 통해 모든 섬 부분 좌표를 Queue에 넣어준다
    * Queue에서 하나씩 poll하며 상하좌우를 살피고, 
    * dist[][]가 -1인 좌표에 dist는 poll한 좌표의 dist + 1로, team은 poll한 좌표의 team으로 갱신하고
    * 해당 좌표를 다시 Queue에 add해준다
 * 위 작업을 반복하면, 모든 바다 좌표 dist에 가장 가까운 섬과의 거리를 저장할 수 있다 
 * 마지막으로 인접한 두 바다좌표 dist 중 합이 최소인 것을 정답 변수에 업데이트하면됨
 * 
 */
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
        int teamNum = 0;

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (team[i][j] ==0 && init[i][j] == 1) {
                    q.add(new Point(j, i));
                    team[i][j] = ++teamNum;
                    while(!q.isEmpty()) {
                        Point p = q.poll();
                        for (int k = 0; k < 4; k ++) {
                            int nx = p.x + dx[k];
                            int ny = p.y + dy[k];

                            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                                if (team[ny][nx] ==0 && init[ny][nx] == 1) {
                                    q.add(new Point(nx, ny));
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
                dist[i][j] = -1;
                if (init[i][j] ==1) {
                    dist[i][j] = 0;
                    q.add(new Point(j, i));
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
                        dist[ny][nx] = dist[p.y][p.x] + 1;
                        q.add(new Point(nx, ny));
                    }
                }
            }
        }

        // 이후, 인접한 dist에서 두 칸의 합 중 최소를 찾으면 됨!
        // (완전탐색, 상하좌우 네 방향에 대해 비교, 및 result값 최솟값으로 갱신)
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k ++) {
                    int nx = j + dx[k];
                    int ny = i + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        if (init[ny][nx] == 0 && init[i][j] == 0 && team[ny][nx] != team[i][j]) {
                            ans = Math.min(ans, dist[i][j]+ dist[ny][nx]);
                        }
                    }
                }
            }
        }
        System.out.println(ans);
        sc.close();
    }
}