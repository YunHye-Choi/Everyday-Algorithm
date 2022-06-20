// https://www.acmicpc.net/problem/2447
// 풀이 참고: https://st-lab.tistory.com/95
import java.util.*;
public class boj_2447 {
    public static char [][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        arr = new char [n][n];
        star(0, 0, n, false);
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++){
                sb.append(arr[i][j]+"");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void star(int r, int c, int N, boolean blank) {
        if(blank){
            for (int i = r; i < r+N; i++) {
                for (int j = c; j < c+N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }
        
        if (N == 1) {
            arr[r][c] = '*';
            return;
        }

        int size = N/3;
        int count = 0;
        for (int i = r; i < r+N; i += size) {
            for (int j = c; j < c+N; j+= size) {
                if (count == 4){
                    star(i, j, size, true);
                } else{
                    star(i, j, size, false);
                }
                count ++;
            }
        }
    }
}
