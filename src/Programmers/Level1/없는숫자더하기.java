import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        HashSet<Integer> hs = new HashSet<>();
        for (int n : numbers){
            hs.add(n);
        }
        for (int i = 0; i < 10; i ++){
            if(!hs.contains(i)) answer += i;
        }
        return answer;
    }
}