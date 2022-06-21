// https://www.acmicpc.net/problem/1992
//https://st-lab.tistory.com/230
// 어렵다.. 풀이 안보고 혼자서도 풀어보기!
import java.util.*;
class Quad {
    int num;
    int lev;
    public Quad(int num, int lev){
        this.num = num;
        this.lev = lev;
    }
}
public class boj_1992{
    public static StringBuilder sb;
    public static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        
        sb = new StringBuilder();
        arr = new int[n][n];
        sc.nextLine();
        for (int i = 0; i < n; i ++){
            String str =sc. nextLine();
            for (int j = 0; j < n ; j ++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        quadTree(0, 0, n);

        System.out.println(sb);
        
    }
    public static void quadTree(int r, int c, int N){
        if (isPossible(r, c, N)) {
            sb.append(arr[r][c]);
            return;
        }
        int size = N/2;
        sb.append('(');

        quadTree(r, c, size);
        quadTree(r, c + size, size);
        quadTree(r + size, c, size);
        quadTree(r + size, c + size, size);

        sb.append(')');
    }
    public static boolean isPossible(int r, int c, int size){
        int val = arr[r][c];
        for (int i = r; i < r + size; i++){
            for (int j = c; j < c + size; j++){
                if(val!=arr[i][j]) return false;
            }
        }
        return true;
    }
}