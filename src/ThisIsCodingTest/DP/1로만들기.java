/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static int []dp = new int [30000];
	public static void main (String[] args) throws java.lang.Exception
	{
		// a: X가 5로 나누어떨어지면 5로 나눈다
		// b: X가 3으로 나누어떨어지면, 3으로 나눈다.
		// c: X가 2로 나누어떨어지면 2로 나눈다.
		// d: X에서 1을 뺀다.
		
		Scanner sc  = new Scanner (System.in);
		int x = sc.nextInt();
		
		// -1로 초기화
		for (int i = 0; i < x+1; i ++)
			dp[i] = -1;
			
		dp[1] = 0; // 초항은 0 (x가 1이면 답은 0)
		System.out.println(solve(x));
		
	}
	
	public static int solve(int x) {
		int ans = 0;
		for (int i = 2; i <= x; i++) {
			int min = 40000;
			if (x % 5 ==0) {
				min = Math.min(min(dp[x/5], min));
			} else if (x % 3 == 0) {
				min = Math.min(min(dp[x/3], min));
			} else if (x % 2 == 0) {
				min = Math.min(dp[x/2], min);
			} else {
				min = Math.min(dp[x-1], min);
			}
			ans ++;
		}
		return ans;
	}
}