package Basics;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 문제: https://www.acmicpc.net/problem/10989
// 해답: https://st-lab.tistory.com/107

// Arrays.sort()이용. 시간제한은 3초, 해결시간은 2300ms로 해결함.
// (촉박하게 해결, 속도 좋지 못함) -> 포스팅하기!

public class boj_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int num : arr){
            sb.append(num).append('\n');
        }
        System.out.println(sb);
    }
}
