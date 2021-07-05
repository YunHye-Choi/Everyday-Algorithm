import java.util.*;

public class Main{
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int [] arr = new int [n];
		for (int i = 0; i < n; i ++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		int count = 0, result = 0;
		for(int num : arr) {
			count ++;
            // 모험가 공포도가 그룹의 모험가 수보다 작거나 같은 경우,
            // 최대한 많은 그룹을 만들어야 하므로, 바로 그룹을 생성해준다
			if (num <= count){
				count = 0;
				result++;
			}
		}
		
		System.out.println(result);
	}
}