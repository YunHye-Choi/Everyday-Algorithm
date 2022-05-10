// https://www.acmicpc.net/problem/2146
// 풀이 참고 https://devowen.com/317
// 1. bfs이용하여 서로 다른 섬 구분하는 team데이터 채우기
// 2. 모든 섬 좌표를 큐에 넣고, poll 하면서 인접한 바다에 team 채우기
// 3. 모든 섬 좌표의 dist는 0으로, 바다 좌표의 dist를 -1로 설정
// 4. 모든 섬 좌표를 큐에 넣고, poll 하면서 인접한 바다 좌표에 대해 현재 값 +1로 dist채우기 
// 5. 서로 다른 team 중 인접한 dist의 최소 합 찾기
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

        // 섬 구분을 위해 team데이터 저장, bfs이용
        int teamno = 1;
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (init[i][j] == 1 && team[i][j] == 0) {
                    q.add(new Point(j, i));
                    team[i][j] = teamno;
                    while (!q.isEmpty()) {
                        Point p = q.poll();
                        int nx, ny;
                        for (int k = 0; k < 4; k++) {
                            nx = p.x + dx[k];
                            ny = p.y + dy[k];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                                if (init[ny][nx] == 1 && team[ny][nx] == 0) {
                                    q.add(new Point(nx, ny));
                                    team[ny][nx] = teamno;
                                }
                            }   
                        }
                    }
                    teamno ++;
                }
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if(init[i][j] == 1) {
                    q.add(new Point(j, i));
                }
            }
        }

        while(!q.isEmpty()) {
            Point p = q.poll();
            int nx, ny;
            for (int k = 0; k < 4; k++) {
                nx = p.x + dx[k];
                ny = p.y + dy[k];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (init[ny][nx] == 0 && team[ny][nx] == 0) {
                        q.add(new Point(nx, ny));
                        team[ny][nx] = team[p.y][p.x];
                    }
                }
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if(init[i][j] == 1) {
                    dist[i][j] = -1;
                    q.add(new Point(j, i));
                }
            }
        }

        while(!q.isEmpty()) {
            Point p = q.poll();
            int nx, ny;
            for (int k = 0; k < 4; k++) {
                nx = p.x + dx[k];
                ny = p.y + dy[k];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (init[ny][nx] == 0 && dist[ny][nx] == 0) {
                        q.add(new Point(nx, ny));
                        if (dist[p.y][p.x] == -1)
                            dist[ny][nx] = 1;
                        else dist[ny][nx] = dist[p.y][p.x] + 1;
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                for (int k = 0; k < 4; k++) {
                    int nx, ny;
                    nx = j + dx[k];
                    ny = i + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        if (team[i][j] != team[ny][nx]) {
                            min = min < dist[i][j] + dist[ny][nx] ? min : dist[i][j] + dist[ny][nx];
                        }
                    }
                }
            }
        }
        if(min == 0) min = 1;

        System.out.println(min);
    }
}