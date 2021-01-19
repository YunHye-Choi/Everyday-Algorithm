package Basics;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 문제: https://www.acmicpc.net/problem/10989
// 해답: https://st-lab.tistory.com/107
/** 시간제한은 3초인데 2300ms로 해결함.
/* ▶ 카운팅 정렬 이용하는 방법에 대해 포스팅 하고 ver2파일 만들어서 풀고 위 블로그처럼 두가지 풀이로 포스팅 작성
/* ▶ 속도가 빠른 입출력에 대해서 포스팅 작성 & 사용법 익히기
 */
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
