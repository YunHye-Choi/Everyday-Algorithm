import java.util.*;
public class boj_10808 {
    public static void main(String[] args ) {
        Scanner sc = new Scanner (System.in);
        char[] word = sc.nextLine().toCharArray();
        int [] alp = new int [26];
        char a = 'a';
        for (int i= 0; i < word.length; i ++) {
            alp[word[i]-a] ++;
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(alp[i] + " ");
        }
    }
}