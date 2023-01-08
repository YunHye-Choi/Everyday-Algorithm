// https://school.programmers.co.kr/learn/courses/30/lessons/42628
import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        for (String str : operations) {
            int num = Integer.parseInt(str.split(" ")[1]);
            if (str.startsWith("I")){
                pq.add(num);
                maxPq.add(num);
            } else {
                if (num == 1) {
                    if (!maxPq.isEmpty()) {
                        pq.remove(maxPq.poll());
                    }
                } else if (num == -1) {
                    if (!pq.isEmpty()) {
                        maxPq.remove(pq.poll());
                    }
                }
            }
        }
        answer = new int[2];
        answer[0] = maxPq.isEmpty() ? 0 : maxPq.poll();
        answer[1] = pq.isEmpty() ? 0 : pq.poll();
        return answer;
    }
}