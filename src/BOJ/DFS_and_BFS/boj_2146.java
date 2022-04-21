// https://www.acmicpc.net/problem/2146
import java.util.*;
public class boj_2146 {
    public static int[][]cost, team;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        cost = new int[n][n];
        team = new int[n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        // 같은 섬 데이터를 team에 저장하고, 
        // 같은 섬인지 아닌지에 따라 다리인지 아닌지 구분해서 최솟값업데이트
    }
}
