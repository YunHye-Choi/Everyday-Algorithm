/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	// d: 앞서 계산한 결과 산출되는 최소 계산횟수를 저장
	public static int []d = new int [30001];

	public static void main (String[] args) throws java.lang.Exception
	{
		// a: X가 5로 나누어떨어지면 5로 나눈다
		// b: X가 3으로 나누어떨어지면, 3으로 나눈다.
		// c: X가 2로 나누어떨어지면 2로 나눈다.
		// d: X에서 1을 뺀다.
		
		Scanner sc  = new Scanner (System.in);
		int x = sc.nextInt();
		// d[1] = 0이고 기본적으로 0으로 초기화 되기 때문에 처리할 필요없음
		// 다이나믹 프로그래밍 진행 (Bottom-Up)
		for (int i = 2; i <= x; i++) {
			// d조건 (연산을 했으므로 +1)
			d[i] = d[i-1] + 1;

			// c조건 (/2한 연산횟수(d)가 기존 것 보다 작으면 새로 /2라는 연산을 해야하므로 +1)
			if (i%2 == 0)
				d[i] = Math.min(d[i], d[i/2] + 1);

			// b조건
			if (i%3 == 0)
				d[i] = Math.min(d[i], d[i/3] + 1);

			// a조건
			if (i%5 == 0)
				d[i] = Math.min(d[i], d[i/5] + 1);
		}

		System.out.println(d[x]);
	}
}