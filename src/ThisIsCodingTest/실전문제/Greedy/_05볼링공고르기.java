import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt(); // 볼링공의 개수는 n
		int m = sc.nextInt(); // 볼링공의 무게는 1~m의 자연수로 존재
        // 윤혜풀이(맞음)
		/*
        int arr[] = new int [n+1];
		 for (int i = 1; i <= n; i ++) {
			arr[i] = sc.nextInt();
		}
		int result = 0;
		for(int i = 1; i <= n-1;i++){
			for(int j = i+1; j <= n ; j ++) {
				if(arr[i]!=arr[j]) {
					result ++;
				}
			}
		}
		System.out.println(result); */

        // 책의 풀이
        int arr[] = new int [10];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[x] ++;
        }

        int result = 0;
        // 1부터 m까지의 각 무게에 대하여 처리
        for (int i = 1; i <= m i++) {
            n -= arr[i]; // 무게가 i인 볼링공의 개수 제외
            result += arr[i] * n; // B가 선택하는 경우의 수와 곱하기
        }
        System.out.println(result);
        // 풀이 리뷰
        // 진짜 발상의 전환이다..
        // 내풀이도 나쁘진 않지만
        // n값과 m값을 다 주는덴 이유가 있으니 m값(더적은)을 최대한 활용해보자.
        // 모두 다르게 본다는 것이 정말 큰 힌트..였다.
	}
}