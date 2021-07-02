package Basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator; // 람다식 사용시 필요 없음
import java.util.Scanner;

// 문제: https://www.acmicpc.net/problem/11651
// 풀이: Collections.sort()를 이용하여 풀이
public class boj_11651_ver2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<Coordi> arr = new ArrayList<>();

        for (int i = 0; i <n; i++) {
            Coordi c = new Coordi(scanner.nextInt(), scanner.nextInt());
            arr.add(c);
        }

        Collections.sort(arr, new Comparator<Coordi>() {
            @Override
            public int compare(Coordi c1, Coordi c2) {
                if (c1.y == c2.y)
                    return c1.x - c2.x;
                else
                    return c1.y - c2.y;
            }
        });
        /*
        위 코드 람다식으로 표현
        Collections.sort(arr, (c1, c2) -> {
            if (c1.y == c2.y)
                return c1.x - c2.x;
            else
                return c1.y - c2.y;
        });
        * */

        for (int i = 0; i < n; i++) {
            System.out.println(arr.get(i));
        }
    }
    static class Coordi {
        int x;
        int y;

        public Coordi (int _x,int _y) {
            x = _x;
            y = _y;
        }
        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
