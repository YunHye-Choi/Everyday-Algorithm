import java.util.*;
// 문제: 이진 탐색 문제
// 첫 줄에 배열의 크기, 두 번째 줄에 오름차순으로 정렬되어있는 수열 입력
// 마지막줄에 찾을 수를 입력
// 해당 수가 있으면 그 위치를 출력 (첫 index =1), 없으면 "X"를 출력

// 이 문제의 핵심은 while문 에서 low와 high더해서 2로 나눈 값인 mid 를 계속 초기화하고
// target이 작거나 큰 것에 따라 low혹은 high를 mid -1로 초기화하는 것
// 또한 수를 찾았을 때 return을 해버리고, 반복문 밖에서 "X"를 출력하는 방식으로~

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int[] arr = new int [n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
        
		int low = 0;
		int high = arr.length-1;
		int mid;
		
		while (low <= high) {
			mid = (low+high) /2;
			if(arr[mid] == target) {
				System.out.println(mid+1);
				return;
			} else if (arr[mid] > target) {
				high = mid - 1;
			} else if (arr[mid] < target){
				low = mid + 1;
			}
		}
		System.out.println("X");
	}
}