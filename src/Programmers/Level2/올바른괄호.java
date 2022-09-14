import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] arr = s.toCharArray();
        Queue<Character> q = new LinkedList<>();
        for (char c : arr) {
            if (c == '(') {
                q.add(c);
            }
            else if (c == ')') {
                if (q.size() == 0) {
                    answer = false;
                    break;
                } else {
                    q.poll();
                }
            }
        }
        if (q.size() != 0) answer = false;
        return answer;
    }
}