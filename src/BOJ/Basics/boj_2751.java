

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

// 문제: https://www.acmicpc.net/problem/2751
// 풀이: https://st-lab.tistory.com/106

public class boj_2751 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        StringBuilder sb = new StringBuilder();

        int n = scanner.nextInt();;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        //Collections.sort()가 자바 지원 sort중 가장 속도 빠름!
        Collections.sort(list);

        // 일반 System.out.println을 여러번 하면 시간초과 발생
        for (int num:list){
           sb.append(num).append('\n');
        }
        System.out.println(sb);
    }
}
