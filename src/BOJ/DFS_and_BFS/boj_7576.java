// https://www.acmicpc.net/problem/7576
import java.util.*;
public class boj_7576 {
    public static int m, n;
    public static int [][] map;
    public static void main(String [] args) {
        Scanner sc = new Scanner (System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        
        map = new int[n][m];

        for (int i = 0; i < n ; i ++) {
            for (int j = 0; j < m; j ++) {  
                map[i][j] = sc.nextInt();
            }
        }

        
    }
}
