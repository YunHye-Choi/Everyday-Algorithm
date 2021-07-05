import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		char [] arrch = line.toCharArray();
		int[] arr = new int[20];
		for (int i = 0; i < line.length(); i ++) {
			arr[i] = arrch[i] - '0';
		}
		int ans = 0;
		for (int num : arr) {
			if (num == 0 || ans == 0) {
				ans += num;
			} else {
				ans *= num;
			}
		}
		System.out.println(ans);
	}
}