// 아이디어 참고하여 개발함.
// 배열 길이가 50일때는 3중 for문 사용하면서 밖 단계 index +1 부터 검사하면 중복없이 3개 고르기 가능
// https://velog.io/@seobob/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%86%8C%EC%88%98%EB%A7%8C%EB%93%A4%EA%B8%B0-Java


import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        ArrayList<Integer> candi = new ArrayList<>();
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++ ){
                for (int k = j+1; k < n;k ++) {
                    candi.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }
        
        for (int tmp: candi) {
            if (tmp == 2) {
                answer++;
                continue;
            }
            if (tmp % 2 == 0){
                continue;
            }
            boolean sosu = true;
            for (int i = 3; i < tmp; i++) {
                if(tmp % i == 0) {
                    sosu = false;
                    break;
                }
            }
            if (sosu) answer++;
        }
        return answer;
    }
}