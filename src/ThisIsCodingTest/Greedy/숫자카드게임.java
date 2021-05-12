/* package whatever; // don't place package name! */
import java.util.Arrays;
// 매우 쉬운 문제..
// 최대 최소값이 필요하면 항 상  정 렬 해!

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here

		// testcase 1
		//int n = 3, m = 3;
		//int arr[][] = {{3, 1, 2}, {4, 1, 4}, {2, 2, 2}};
		
		// testcase 2
		int n = 2, m = 4;
		int arr[][] = {{7, 3, 1, 8}, {3, 3, 3, 4}};
		
		int minInRow = 99999, solution = -1;
		for (int row = 0; row < n; row ++) {
            // 평소에 많이 썼던 3항 연산자를 이용한 최솟값 구하는 법
			/*minInRow = 99999;
			for (int col = 0; col < m; col ++) {
				minInRow = arr[row][col] < minInRow ? arr[row][col] : minInRow;
			}*/

            // Arrays.sort()를 이용한 최대 최소값 구하는 방법 - 최대값은 마지막 요소 갖고오는식으로 응용
            Arrays.sort(arr[row]);
            minInRow = arr[row][0];
			solution = solution < minInRow ? minInRow : solution;
		}
		System.out.println(solution);
	}
}