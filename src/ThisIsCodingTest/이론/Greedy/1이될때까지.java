/* package whatever; // don't place package name! */
// 너무 쉬운 문제였다..
// 책 풀이를 보니 while에서 if-else구조가 아니라 
// while에서는 최대한 많이 나누는 동작만 실행한 뒤
// 남은 n에 1을 빼고 solution에 더하는..!! 방법도 있었다.
/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// testcase1
		//int n = 25, k = 5;
		
		// testcase2
		int n = 17, k = 4;
		int solution = 0;
		while (n != 1) {
			if (n % k == 0) {
				n /= k;
			} else {
				n--;
			}
			solution++;
		}
		System.out.println(solution);
	}
}