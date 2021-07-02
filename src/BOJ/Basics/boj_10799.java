package Basics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
// 문제: https://www.acmicpc.net/problem/10799
// 내가 한 풀이.. 테케는 통과했지만 시간초과. stack을 순회 하지 않는 방법 찾음
// 그 방법: https://dundung.tistory.com/5

public class boj_10799 {
    //public static int pieces = 0;
    //public static Stack<Integer> stick = new Stack<>(); // 각 stick의 값은 그 stick을 통과하는 laser개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        /*
        // 내 풀이
        for (int index = 0; index < chars.length; ) {
            if (chars[index] == '(') {
                if (chars[index + 1] == ')') { // () 즉, 레이저라면
                    for (int j = 0; j < stick.size(); j++) {
                        stick.set(j, stick.get(j) + 1);
                    }
                    index += 2;
                } else { // 막대라면
                    stick.push(0); // 아직 레이저가 통과하지 않은 것을 의미하는 0의 stick을 push
                    index++;
                }
            } else { // ')'라면
                pieces += stick.pop() + 1; // 총 개수에 쪼개진 막대 더하기
                index++;
            }
        }
        System.out.println(pieces);*/

        // 구글링해서 찾은 풀이
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for(int i=0; i<chars.length; i++) {
            if(chars[i] == '(') // 레이저든 막대든 일단 index값으로 push
                stack.push(i);
            else {
                if(stack.peek() == i-1) { // )가 레이저의 끝이었다면
                    stack.pop(); // push는 pop해서 없던일로 하고
                    count+=stack.size(); // 남아있던 stack의 크기 (쇠맥막대 개수)를 count에 더하기
                }
                else { // )가 막대의 끝이라면
                    stack.pop(); // 끝난 막대니까 없애버리고
                    count++; // 레이저의 개수 + 1이 잘린 조각 개수니까, 1 더해주기
                }
            }
        }
        System.out.println(count);
    }
}
