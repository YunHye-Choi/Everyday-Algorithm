//https://programmers.co.kr/learn/courses/30/lessons/42891 
// 나의 정답
/**
 * 정확성  테스트
테스트 1 〉	통과 (0.24ms, 52.6MB)
테스트 2 〉	통과 (0.26ms, 52.1MB)
테스트 3 〉	통과 (2.42ms, 53.8MB)
테스트 4 〉	통과 (0.28ms, 52.3MB)
테스트 5 〉	통과 (0.26ms, 53.3MB)
테스트 6 〉	통과 (0.24ms, 52.7MB)
테스트 7 〉	통과 (0.36ms, 52.3MB)
테스트 8 〉	통과 (0.39ms, 52.3MB)
테스트 9 〉	통과 (0.37ms, 52.2MB)
테스트 10 〉	통과 (0.27ms, 53.9MB)
테스트 11 〉	통과 (0.40ms, 52.6MB)
테스트 12 〉	통과 (0.37ms, 53MB)
테스트 13 〉	통과 (0.27ms, 52.7MB)
테스트 14 〉	통과 (0.44ms, 53.2MB)
테스트 15 〉	통과 (0.44ms, 52.1MB)
테스트 16 〉	실패 (런타임 에러)
테스트 17 〉	통과 (0.26ms, 52.1MB)
테스트 18 〉	통과 (0.26ms, 51.7MB)
테스트 19 〉	실패 (런타임 에러)
테스트 20 〉	통과 (0.30ms, 52.3MB)
테스트 21 〉	통과 (1.12ms, 51.9MB)
테스트 22 〉	통과 (1.96ms, 52.2MB)
테스트 23 〉	실패 (런타임 에러)
테스트 24 〉	통과 (9.05ms, 53.2MB)
테스트 25 〉	통과 (7.14ms, 52MB)
테스트 26 〉	통과 (14.46ms, 54MB)
테스트 27 〉	통과 (22.11ms, 52.3MB)
테스트 28 〉	통과 (0.30ms, 52.8MB)
테스트 29 〉	통과 (0.24ms, 52.8MB)
테스트 30 〉	통과 (0.25ms, 52.1MB)
테스트 31 〉	통과 (0.24ms, 52.2MB)
테스트 32 〉	통과 (0.25ms, 52.5MB)
효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)
테스트 5 〉	실행 중단
테스트 6 〉	실행 중단
테스트 7 〉	실행 중단
테스트 8 〉	실행 중단
 */
/* import java.util.*;
class Solution {
    public class Pair {
            public int idx;
            public int val;
            public Pair(int i, int v) {
                idx = i;
                val = v;
            }
        }
    public int solution(int[] food_times, long k) {
        
        int answer = 0;
        
        // k초에 먹게 될 음식은?
        // result에는 k초 후 남은 음식의idx가 저장되어 있아야
        int index = 0;
        ArrayList<Pair> arr = new ArrayList<>();
        for (int i = 1; i <= food_times.length; i++) {
            arr.add(new Pair(i, food_times[i-1]));
        }
        for (int i = 0; i <= k; i++) {
            
            if (index == arr.size()) index = 0;
            
            answer = arr.get(index).idx;
            //System.out.println(arr.get(index).idx + ": " + arr.get(index).val);
            
            arr.get(index).val = arr.get(index).val-1;
            if (arr.get(index).val == 0) {
                arr.remove(index);
                index--;
            }
            if (arr.size() == 0 && i < k-1) {
                answer = -1;
                break;
            }
            index++;
            
        }
        return answer;
    }
} */
import java.util.*;

class Food implements Comparable<Food> {

    private int time;
    private int index;

    public Food(int time, int index) {
        this.time = time;
        this.index = index;
    }

    public int getTime() {
        return this.time;
    }

    public int getIndex() {
        return this.index;
    }

    // 시간이 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Food other) {
        return Integer.compare(this.time, other.time);
    }
}

class Solution {
    public int solution(int[] food_times, long k) {
        // 전체 음식을 먹는 시간보다 k가 크거나 같다면 -1
        // (K초 안에 모든 음식을 다 먹어버리면 더이상 먹을 음식이 없게 됨)
        long summary = 0;
        for (int i = 0; i < food_times.length; i++) {
            summary += food_times[i];
        }
        if (summary <= k) return -1;

        // 시간이 작은 음식부터 빼야 하므로 우선순위 큐를 이용
        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            // (음식 시간, 음식 번호) 형태로 우선순위 큐에 삽입
            pq.offer(new Food(food_times[i], i + 1));
        }

        summary = 0; // 먹기 위해 사용한 시간
        long previous = 0; // 직전에 다 먹은 음식 시간
        long length = food_times.length; // 남은 음식의 개수

        // (summary + (현재의 음식시간 - 이전 음식 시간) * 현재 음식 개수)와 k 비교
        // k보다 작거나 같아야 k초 안에 할 수 있는 일이므로!
        while (summary + ((pq.peek().getTime() - previous) * length) <= k) {
            int now = pq.poll().getTime();
            summary += (now - previous) * length;
            length -= 1; // 다 먹은 음식 제외
            previous = now; // 이전 음식 시간 재설정
        }
        
        // summary가 k보다 크다면,
        // 남은 음식 중에서 몇 번째 음식인지 확인하여 출력
        ArrayList<Food> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        // 음식의 번호 기준으로 정렬
        Collections.sort(result, new Comparator<Food>() { 
            @Override
            public int compare(Food a, Food b) {
                return Integer.compare(a.getIndex(), b.getIndex());
            }
        });
        //(k - summary) % length 
        // = k-할애한시간(summary): 남은시간이고, length로 나눈 나머지이므로, 해당 차례의 음식이게 된다
        // (ArrayList는 0기준 index라서 자동으로 k초 + 1의 음식이 오게 됨)
        return result.get((int) ((k - summary) % length)).getIndex();
    }
}