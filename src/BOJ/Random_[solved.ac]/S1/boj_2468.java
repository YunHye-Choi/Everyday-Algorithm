// https://www.acmicpc.net/problem/2468
// 그어어의 한번에 풀었다 ㅎㅎ
import java.util.*;
class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class boj_2468 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();

        int[][] arr= new int[n][n];
        boolean [][] visit = new boolean [n][n];
        int []dx = {0, 0, -1, 1};
        int []dy = {-1, 1, 0, 0};

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i ++){
            for (int j = 0; j < n ; j++) {
                arr[i][j] = sc.nextInt();
                min = Math.min(min, arr[i][j]);
                max = Math.max(max, arr[i][j]);
            }
        }
        ArrayList<Integer> candi = new ArrayList<>();
        for (int h = min; h <= max; h++) {
            int cnt = 0;
            visit = new boolean[n][n];
            for (int i = 0; i < n; i ++) {
                for (int j = 0; j < n ; j++) {
                    if (arr[i][j] >= h && !visit[i][j]){
                        Queue <Point> q = new LinkedList<>();
                        q.add(new Point(j, i));
                        visit[i][j] = true;
                        while(!q.isEmpty()) {
                            Point p = q.poll();
                            for (int k = 0; k < 4 ;k ++){
                                int nx = p.x + dx[k];
                                int ny = p.y + dy[k];
                                if (nx >= 0 && ny >= 0 && nx < n && ny < n){
                                    if(!visit[ny][nx] && arr[ny][nx] >= h) {
                                        q.add(new Point (nx, ny));
                                        visit[ny][nx] = true;
                                    }
                                }
                            }
                        }
                        cnt ++;
                    }
                }
            }
            candi.add(cnt);
        }

        int ans = Integer.MIN_VALUE;
        for (int c : candi) {
            ans = Math.max(c, ans);
        }
        
        System.out.println(ans);
    }
}
