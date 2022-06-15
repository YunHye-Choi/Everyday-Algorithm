import java.util.*;
public class boj_2247 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        char[][] mini = new char[3][3];
        for (int i = 0; i < 3; i ++){
            for (int j = 0; j < 3; j++) {
                if (i == j && i == 1) {
                    mini[i][j] = ' ';
                } else {
                    mini[i][j] = '*';
                }
            }
        }
        int n = sc.nextInt();
        if (n == 1) {
            for (int i = 0; i < 3; i ++){
                for (int j = 0; j < 3; j++) {
                    System.out.println(Character.toString(mini[i][j]));
                }
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        int k = (int) Math.cbrt(n); // n == 3^k
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i <= Math.pow(3, k-1) && i < Math.pow(3, k-1) * 2 - 1) {
                    sb.append(" ");
                }else if (){
                    
                }
            }
            sb.append("\n");
        }
    }
}
