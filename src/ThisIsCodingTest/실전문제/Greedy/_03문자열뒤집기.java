import java.util.*;

public class Main {
	Scanner sc = new Scanner (System.in);
	String str = sc.nextLine();
	char[] arr = str.toChaArray();
	
	// 할 수 있는 동작: 연속된 1개 이상의 문자를 뒤집기
	// 모두 같은 문자로 만들기 위한 최소 동작의 수 구하기
	// 연속되는 1과 0의 그룹의 수를 세고, 연속0의 그룹의 수와 연속 1의 그룹의 수 중 더 적은 것을 반환
	int a, b = 0;
	int cnt =0;
	char past = arr[0];
	for (int i = 1; i < arr.length; i++) {
		cnt ++;
		char curr = arr[i];
		if (curr != past) {
			cnt = 0;
			ar
		}
	}
}