import java.util.*;

public class Main {
	public static void main(String[] args) {
		// 동전 개수 N과 각 N개의 동전의 금액이 주어졌을 때
		// 그 동전들의 합으로 이루어질 수 없는 숫자 중 최솟값
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int [n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int num = 1;
	
		Array.sort(arr);
		
		while(true) {
			// 로직 구현해야 함
			// 아이디어:
			// num을 1씩 늘려가며 반복문 수행
			num++
			
			// 만약 arr들의 합으로 num이 구해지면 continue;
			// else, break
		}
	}
}
