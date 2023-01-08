import java.util.*;
public class boj_10026{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] arr = new char[n][n];
        sc.nextLine();
        for (int i = 0 ; i < n ; i ++) {
            String[] str = sc.nextLine().split("");
            for (int j = 0; j < n; j ++) {
                char[] charArr = str[j].toCharArray();
                arr[i][j] = charArr[0];
            }
        }
         
        int ans1 = 0, ans2 = 0;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        boolean[][] visit = new boolean[n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                if (!visit[i][j]){
                    ans1++;
                    Queue<Point> q = new LinkedList<>();
                    q.add(new Point(j, i, arr[i][j]));
                    visit[i][j] = true;
                    while(!q.isEmpty()) {
                        Point p = q.poll();
                        for (int k = 0; k < 4; k ++) {
                            int nx = p.x + dx[k];
                            int ny = p.y + dy[k];
                            if (nx >=0 && nx < n && ny >=0 && ny < n ) {
                                if (!visit[ny][nx] && p.color == arr[ny][nx]) {
                                    q.add(new Point (nx, ny, arr[ny][nx]));
                                    visit[ny][nx] = true;   
                                }
                            }
                        }   
                    }
                    
                }
            }
        }
        
        visit = new boolean[n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                if (!visit[i][j]){
                    ans2++;
                    Queue<Point> q = new LinkedList<>();
                    q.add(new Point(j, i, arr[i][j]));
                    visit[i][j] = true;
                    while(!q.isEmpty()) {
                        Point p = q.poll();
                        for (int k = 0; k < 4; k ++) {
                            int nx = p.x + dx[k];
                            int ny = p.y + dy[k];
                            if (nx >=0 && nx < n && ny >=0 && ny < n ) {
                                if (!visit[ny][nx]) {
                                    if ((p.color == 'R' && arr[ny][nx] == 'G') 
                                        || (p.color == 'G' && arr[ny][nx] == 'R')
                                        || (p.color == arr[ny][nx])) {
                                            q.add(new Point (nx, ny, arr[ny][nx]));
                                            visit[ny][nx] = true;  
                                        }
                                }
                            }
                        }   
                    }
                    
                }
            }
        }
        
        
        System.out.println(ans1 + " " + ans2);
        
    }
    static class Point {
        int x;
        int y;
        char color;
        Point(int x, int y, char color){
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}