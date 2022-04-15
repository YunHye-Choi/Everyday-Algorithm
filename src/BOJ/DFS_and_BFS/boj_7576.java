// https://www.acmicpc.net/problem/7576
// 풀이참고: https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-7576%EB%B2%88-%ED%86%A0%EB%A7%88%ED%86%A0-%EC%9E%90%EB%B0%94Java

import java.util.*;

class Tomato {
    int x;
    int y;

    Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class boj_7576 {
    public static int m, n;
    public static int [][] map;
    public static int [] dx = {0, 0, -1, 1};
    public static int [] dy = {1, -1, 0, 0};
    public static Queue<Tomato> q;

    public static void main(String [] args) {
        Scanner sc = new Scanner (System.in);
        m = sc.nextInt(); // y
        n = sc.nextInt(); // x

        map = new int[n][m];

        q = new LinkedList<Tomato>();

        for (int i = 0; i < n ; i ++) {
            for (int j = 0; j < m; j ++) {  
                map[i][j] = sc.nextInt();

                // 익은 토마토 queue에 넣기
                if (map[i][j] == 1) {
                    q.add(new Tomato(i, j));
                }
            }
        }

        System.out.println(bfs());
    }
    public static int bfs(){
        while(!q.isEmpty()) {
            Tomato t = q.poll();

            int x = t.x;
            int y = t.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 0) {
                        q.add(new Tomato(nx, ny));
                        // 인접 토마토의 숫자를 누적함으로서 며칠이 걸려 익은건 지 확인가능
                        map[nx][ny] = map[x][y] +1;
                    }
                }
            }
        }

        int result = -1;

        // bfs로 가능한 토마토들 다 익게 하고, 최대값을 정답으로 뽑아내기
        for (int i = 0; i < n ; i ++) {
            for (int j = 0; j < m; j ++) {
                if (map[i][j] == 0) {
                    return -1; // 하나라도 안익었다면 -1
                }
                result = Math.max(result, map[i][j]);
            }
        }

        // 0일쨰 익어있는 톰아토 값이 1이기 때문에 1일차부터 계산하려면 1빼야함
        // 이렇게 하면 처음부터 모두 익어있는 케이스 (result == 1)도 커버 가능
        return (result - 1);
    }
}