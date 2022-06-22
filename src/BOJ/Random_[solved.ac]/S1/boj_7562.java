// 전반적인 아이디어는 내가! (보자마자 bfs 사용해야겠다 싶었고, 적용함)
// 아래 블로그에서 특정 조건일때 break해야 하는 거면, 다음 거가 아니라 poll하자마자 검사해야한다는 것 깨닫고 구현
// https://onejunu.tistory.com/110
import java.util.*;
class Point{
    int row;
    int col;
    int lev;

    public Point (int r, int c, int l) {
        this.row = r;
        this.col = c;
        this.lev = l;
    }
}
public class boj_7562 {
    public static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int[] dc = {-1, -2, -2, -1, 1, 2, 2, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int [] size = new int[t];
        int [] ans = new int[t];
        ArrayList<Point> start = new ArrayList<>();
        ArrayList<Point> goal = new ArrayList<>();
        for(int i = 0; i < t; i ++) {
            int tmp1 = sc.nextInt();
            int tmp2 = sc.nextInt();
            int tmp3 = sc.nextInt();
            int tmp4 = sc.nextInt();
            int tmp5 = sc.nextInt();
            size[i] = tmp1;
            Point p = new Point(tmp1, tmp2, tmp3);
            start.add(new Point(tmp2, tmp3, 0));
            goal.add(new Point(tmp4, tmp5, 0));

            
        }
        for (int i = 0; i < t; i ++){
            int n = size[i];
            boolean[][] visit = new boolean[n][n];
            Queue<Point> q = new LinkedList<>();
            Point tmp = start.get(i);
            q.add(tmp);
            visit[tmp.row][tmp.col] = true;
            while(!q.isEmpty()) {
                Point p = q.poll();
                
	            if(goal.get(i).row == p.row && goal.get(i).col == p.col) {
	            	ans[i] = p.lev;
	            	break;
	            }
	               
                for (int j = 0; j < 8; j ++) {
                    int nr = p.row + dr[j];
                    int nc = p.col + dc[j];
                    int nl = p.lev + 1;
                    if (nr >= 0 && nc >= 0 && nr < n && nc < n){
                        if (!visit[nr][nc]) {
                            q.add(new Point(nr, nc, nl));
                            visit[nr][nc] = true;
                        }
                    }
                }
            }
        }
        for (int a : ans) {
        	System.out.println(a);
        }
    }
}
