// https://www.acmicpc.net/problem/1149
// 풀이(규칙만) 참고: https://st-lab.tistory.com/128
// 세가지 경우의 수만 존재하니 각각의 상황을 다 고려하는 게 단순할 수 있음
// 값 자체를 업데이트하며 비교하는 것에 익숙해지기


import java.util.*;

public class boj_1149 {
    public static void main(String[] args) {
        Scanner  sc = new Scanner (System.in);
        int n = sc.nextInt();
        int[][] cost = new int [n][3];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < 3; j++ ) {
                cost[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i < n; i ++) {
            cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]);
            cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]);
            cost[i][2] += Math.min(cost[i-1][0], cost[i-1][1]);
        }
        System.out.println(Math.min(Math.min(cost[n-1][0], cost[n-1][1]), cost[n-1][2]));
    }
}
