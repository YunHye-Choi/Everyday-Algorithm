/* package whatever; // don't place package name! */

// 매우 쉬운 문제..

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
			minInRow = 99999;
			for (int col = 0; col < m; col ++) {
				minInRow = arr[row][col] < minInRow ? arr[row][col] : minInRow;
			}
			solution = solution < minInRow ? minInRow : solution;
		}
		System.out.println(solution);
	}
}