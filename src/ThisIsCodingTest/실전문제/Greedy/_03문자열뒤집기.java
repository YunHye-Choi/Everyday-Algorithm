import java.util.*;
import java.lang.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String str = sc.nextLine();
		char[] arr = str.toCharArray();
		
		// 할 수 있는 동작: 연속된 1개 이상의 문자를 뒤집기
		// 모두 같은 문자로 만들기 위한 최소 동작의 수 구하기
		// 연속되는 1과 0의 그룹의 수를 세고, 연속0의 그룹의 수와 연속 1의 그룹의 수 중 더 적은 것을 반환
		int zero = 0, one = 0;
		char past = arr[0];
		
		if (arr[0] == '0') zero++;
		else one++;
		
		for (int i = 1; i < arr.length; i++) {
			char curr = arr[i];
			if (curr != past) {
				if (curr == '1')
					one++;
				else zero ++;
			}
			past = curr;
		}
		
		int result = Math.min(one, zero);
		System.out.println(result);
	}
	
}
