package Basics;

import java.util.Scanner;

// 문제: https://www.acmicpc.net/problem/9012
// 겁나쉬움, 스스로해결

public class boj_9012 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.next();
        }
        for (int i = 0; i < n; i++) {
            decideYesOrNo(strings[i]);
        }
    }
    public static void decideYesOrNo (String string) {
        char[] charArray = string.toCharArray();
        int a = 0, b = 0;
        for (int i  = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                a++;
            } else if (charArray[i] == ')') {
                b++;
                if (a < b)  {
                    System.out.println("NO");
                    return;
                }
            }
        }
        if (a == b) System.out.println("YES");
        else System.out.println("NO");
    }
}
