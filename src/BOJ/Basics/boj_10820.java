// 문자열 수 안알려줄때는 hasNextLine통해서 입력받기
// https://www.acmicpc.net/problem/10820
import java.util.*;
public class boj_10820 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str ="";
        int[][] ans = new int [100][4];
        int idx = 0;
        while (sc.hasNextLine()) {
            str = sc.nextLine();
            char[] arr = str.toCharArray();
            for (char c : arr) {
                if(c == ' ') {
                    ans[idx][3] ++;
                } else if('0' <= c && c <='9') {    
                    ans[idx][2] ++;
                } else if('A' <= c && c <='Z') {
                    ans[idx][1] ++;
                } else if ('a' <= c && c <='z'){
                    ans[idx][0]++;
                }
            } 
            idx++;
        }
        for (int i = 0; i < idx; i++) {
            System.out.println(ans[i][0] + " " + ans[i][1] + " " + ans[i][2] + " " + ans[i][3]);
        }
    }
}