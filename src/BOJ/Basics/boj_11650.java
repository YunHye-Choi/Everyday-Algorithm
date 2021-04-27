package Basics;

import java.util.Arrays;
import java.util.Scanner;

// 문제: https://www.acmicpc.net/problem/11650
// 풀이: https://st-lab.tistory.com/110

public class boj_11650 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int  n = scanner.nextInt();

        int [][] arr = new int[n][2];

        for (int i = 0; i <n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        // 람다식 이용 (자세한 것은 블로그)
        Arrays.sort(arr, (e1, e2)-> {
            if (e1[0] == e2[0]) {
                return e1[1] - e2[1];
            } else {
                return e1[0] - e2[0];
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
