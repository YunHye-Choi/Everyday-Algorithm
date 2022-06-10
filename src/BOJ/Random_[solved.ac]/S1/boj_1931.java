package S1;
//https://www.acmicpc.net/problem/1931
//기본적인 아이디어는 맞는 방향으로 잘 떠올림!!ㅠㅠㅠ, 구현도 잘 함 (근데 틀렸음)
// 백준 채점할때 몇개는 맞고 몇개는 틀리면 예외처리에서 문제일 가능성 있으니 확인하기🌟🌟🌟
// 풀이참고 (내 풀이가 맞단걸 확인만함!):https://yongku.tistory.com/1612

import java.util.*;
public class boj_1931 {
    public static void main(String[] args) {
        // 시각을 배열로 두면 안됨 (시간초과남)
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i ++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr[i][0] = s;
            arr[i][1] = e;
        }
        // 이차원배열 sorting 참고: https://ifuwanna.tistory.com/328
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int [] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        int ans = 1;
        int minE = arr[0][1];
        for (int i = 1; i < n; i ++) {
            int s = arr[i][0];
            int e = arr[i][1];
            if (minE <= s) {
                minE = e;
                ans++;
            } else {
                minE = Math.min(minE, e);
            }
        }
        System.out.println(ans);
    }
}
