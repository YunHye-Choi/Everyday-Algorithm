import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		char temp_arr[] = str.toCharArray();
		int n = temp_arr.length;
		int arr [] = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = temp_arr[i] - '0';
		}
		
		int left  = 0, right = 0;
		for(int i = 0; i < n/2; i ++) {
			left += arr[i];
		}
		for(int i = n/2; i < n; i ++) {
			right += arr[i];
		}
		
		if (left == right) {
			System.out.println("LUCKY");
		}
		else {
			System.out.println("READY");
		}
	}
}
