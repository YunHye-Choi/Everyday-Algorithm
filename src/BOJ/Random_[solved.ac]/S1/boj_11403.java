// https://www.acmicpc.net/problem/11403
import java.util.*;
public class boj_11403 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        int[][] ans = new int[n][n];
        
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = -1;
            }
        }
 
        // DFS 사용하여 해결하면 됨!

    }
}
