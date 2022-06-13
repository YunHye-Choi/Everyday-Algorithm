// https://www.acmicpc.net/problem/1932
// 히힛 내가 풀었다 ~! (BFS 쓰면 터짐!, 단순 이차원 배열 활용한 DP)
import java.util.*;
class Node {
    int row;
    int sum;
    public Node (int row, int sum) {
        this.row = row;
        this.sum = sum;
    }
}
public class boj_1932 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] arr = new int[n][n];
        for (int i = 0; i < n; i ++) {
            Arrays.fill(arr[i], -1);
        }
        
        for(int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j ++){
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = n-2 ; i >= 0; i--){
            for (int j = 0; j <= i; j++){
                arr[i][j] = Math.max(arr[i][j] + arr[i+1][j], arr[i][j] + arr[i+1][j+1]);
            }
        }
        System.out.println(arr[0][0]);
    }
}
