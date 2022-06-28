import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> hs = new HashSet<>();
        for (int n : nums) {
            hs.add(n);
        }
        if (nums.length/2 < hs.size()) {
            answer = nums.length/2;
        } else answer = hs.size();
        return answer;
    }
}