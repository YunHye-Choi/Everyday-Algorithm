import java.util.*;

public class Main{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char arr[] = str.toCharArray();
		int n = arr.length;
		
		ArrayList<Character> letter = new ArrayList<>();
		int [] num = new int [10000];
		int index_l = 0, index_n = 0;
		for(int i = 0; i < n; i ++) {
			if ('A'<=arr[i]&&'Z'>=arr[i]) {
				letter.add(arr[i]);
				index_l++;
				
			}else if ('0'<=arr[i]&&'9'>=arr[i]) {
				num [index_n++] = arr[i] - '0';
			}
		}
		
		Collections.sort(letter);
		
		int ans = 0;
		for (int i : num) {
			ans += i;
		}
		for (int i = 0; i < index_l; i ++) {
			System.out.print(letter.get(i));
		}
		
		System.out.println(ans);
	}
}