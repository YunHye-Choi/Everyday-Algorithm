public class _1번 {
    public int solution(int[][] customer) {
        int answer = 0;
        int max = 0;
        for (int i = 0; i < customer.length; i++) {
            max = customer[i][1] > max ? customer[i][1] : max;
        }
        boolean [] check = new boolean[max+1];
        for (int i = 0; i < customer.length; i++) {
            for (int j = customer[i][0]+1; j <= customer[i][1]; j++){
                check[j] = true;
            }
                
        }
        boolean last_check = false;
        for (int i = 0; i <= max; i++) {
            if(check[i]) {
                answer ++;
            }
        }
        return answer;
    }
}
// 시간초과

class Solution {
    public int solution(int[][] customer) {
        int answer = 0;
        int max = 0;
        // 시작 시간 기준 내림차순 정렬
        for (int i = 0; i < customer.length; i++) {
            for (int j = i; j < customer.length; j++)
            if (customer[j][0] < customer[i][0]) {
                int temp = customer[j][0];
                customer[j][0] = customer[i][0];
                customer[i][0] = temp;
                if (customer[j][1] < customer[i][1]) {
                    temp = customer[j][1];
                    customer[j][1] = customer[i][1];
                    customer[i][1] = temp;
                }
            }
        }
        int last_start = -1;
        int last_end = -1;
        
        for (int i = 1; i < customer.length; i++) {
            int start = customer[i][0];
            int end = customer[i][1];
            if (i == 0) {
                answer += (end-start);
            } else {
                if (start > last_end) {
                    answer += (end-start);
                } else if (end > last_end) {
                    answer += (end-last_end);
                } 
            }
            last_start = last_start > start ? last_start : start;
            last_end = last_end > end ? last_end : end;
        }

        return answer;
    }
}