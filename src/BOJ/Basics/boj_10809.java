// https://www.acmicpc.net/problem/10809
import java.util.*;
public class boj_10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] alp = new int [26];
        for (int i = 0; i < 26; i ++){
            alp[i] = -1;
        }
        char[] charArr = str.toCharArray();
        int i = 0;
        for(char c: charArr) {
            int idx = c - 'a';
            if(alp[idx] == -1) {
                alp[idx] = i;
            }
            i++;
        }
        for (int num: alp) {
            System.out.print(num + " ");
        }
    }
}
