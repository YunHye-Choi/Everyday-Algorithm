package Basics;

// 문제: https://www.acmicpc.net/problem/10828
// 스스로 해결!

import java.io.BufferedReader;
import java.util.Stack;
import java.io.InputStreamReader;
import java.io.IOException;

public class boj_10828 {
    private static Stack<Integer> stack = new Stack<>();
    public static void main(String[]args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] commands = new String[n];
        for (int i = 0; i < n; i ++){
            commands[i] = bf.readLine();
        }
        String[] subString;
        for (int i = 0; i < n ; i++) {
            subString = commands[i].split(" ");
            commandExecution(subString);
        }
    }
    private static void commandExecution (String[] subString) {
        if (subString.length == 2) {
            // push 명령어
            stack.push(Integer.parseInt(subString[1]));
            return;
        }
        if (subString[0].equals("pop")) { // pop 명령어
            if (stack.size() == 0) System.out.println("-1");
            else System.out.println(stack.pop());
        } else if (subString[0].equals("size")) { // size 명령어
            System.out.println(stack.size());
        } else if (subString[0].equals("empty")) { // empty 명령어
            if (stack.isEmpty()) System.out.println("1");
            else System.out.println("0");
        } else { // top명령어
            if (stack.size() == 0) System.out.println("-1");
            else System.out.println(stack.peek());
        }
    }
}
