// https://school.programmers.co.kr/learn/courses/30/lessons/12938
// 아니 뭔 시간초과가 n loop 두번만 돌려도 나냐 이 깐깐징어야
import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer;
        int k = s%n;
        int num = s/n;
        if (num == 0) {
            answer = new int [1];
            answer[0] = -1;
            return answer;
        }

        answer = new int[n];
        for (int i = 0; i < n; i ++) {
            if (i >= n-k) {
                answer[i] = num+1;
            } else {
                answer[i] = num;
            }
        }
        return answer;
    }
}