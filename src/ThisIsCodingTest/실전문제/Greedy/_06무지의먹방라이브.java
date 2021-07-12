//https://programmers.co.kr/learn/courses/30/lessons/42891 
class Solution {
    public int solution(int[] food_times, long k) {
        int answer = 0;
        
        // k초에 먹게 될 음식은?
        int idx = 0;
        for (int i = 0; i < k; i ++) {
            if(idx == food_times.length) idx = 0;
            if(food_times[idx] > 0) {
                food_times[idx]--;
                answer = idx+1;
            }
            idx++;
        }
        
        return answer;
    }
}