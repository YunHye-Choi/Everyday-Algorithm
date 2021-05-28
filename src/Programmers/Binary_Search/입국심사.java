// 출처: https://yubh1017.tistory.com/30
import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long start, mid, end;
        start = 0;
        end  = Long.MAX_VALUE;
        long sum;
        
        // 모든 사람이 심사 받는데 걸리는 시간 이분 탐색
        // mid: 모든 사람이 심사를 받는 데 주어진 총 시간
        // sum: 주어진 시간(mid)동안 심사를 받을 수 있는 총 사람 수
        while (start <= end) {
            mid = (start+end)/2;
            sum = 0;
            
            for (int i = 0; i < times.length; i++) {
                sum += mid/times[i]; // mid동안 times[i]에 해당하는 심사관이 검사할 수 있는 사람 수
            }
            
            // 각 검사관이 담당할수 있는 사람수의 총합이 총 사람수보다 적은경우, 즉 검사 다 못할 때 (시간부족)
            if (n > sum) {
                start = mid + 1;
            }
            
            // 검사 다 했을 때 (시간이 남음)
            // 최소 시간 찾아야 함
            else {
                end = mid - 1;
                answer = Math.min(answer, mid);
            }
        }
        return answer;
    }
}

// 문제의 포인트는 구하고자 하는 값을 이분 탐색 하는것!
// 시간의 최솟값을 구하고자 하므로 시간을 "전체수 범위"에서 mid를 구하며
// 필요한 조건마다 구간을 좁혀나가는 방식으로 접근해야함