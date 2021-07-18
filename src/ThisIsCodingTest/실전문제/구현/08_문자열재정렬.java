import java.util.*;

public class Main{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char arr[] = str.toCharArray();
		int n = arr.length;
		
		char [] letter = new char[10000];
		int [] num = new int [10000];
		int index_l = 0, index_n = 0;
		for(int i = 0; i < n; i ++) {
			if ('A'<=arr[i]&&'Z'>=arr[i]) {
				letter[index_l] = arr[i];
				index_l++;
				
			}else if ('0'<=arr[i]&&'9'>=arr[i]) {
				num [index_n++] = arr[i] - '0';
			}
		}
		int int_letter [] = new int[10000];
		for (int i = 0; i < index_l; i ++) {
			int_letter[i] = (int) letter[i];
		}
		
		Arrays.sort(letter);
		
		for ()
		int ans = 0;
		for (int i : num) {
			ans += i;
		}
		for (int i = 0; i < index_l; i ++) {
			System.out.print(i+":"+letter[i]);
		}
		
		System.out.println(ans);
	}
}