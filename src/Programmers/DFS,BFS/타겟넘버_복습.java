// BFS 개념 복습
// Queue에 넣어놓고 쭉쭉 뺴면서 진행
import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int x = 0, answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(numbers[x]);
        q.offer(-numbers[x]);
        x++;
        
        while (true) {
            int y = q.poll();
            q.offer(y + numbers[x]);
            q.offer(y - numbers[x]);
            
            if (q.size() == Math.pow(2, numbers.length)) break;
            if (q.size() == Math.pow(2, x + 1)) x++;
        }
        
        int size = q.size();
        for (int i = 0; i < size; i ++) {
            if (q.poll() == target) answer++;
        }
        
        return answer;
        
    }
}