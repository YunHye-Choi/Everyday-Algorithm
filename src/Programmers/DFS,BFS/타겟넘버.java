import java.util.*;
import java.lang.*;

// bfs로 풀어본다!
// 풀었다 ㅜㅜ bfs자체 코드는 얼마 안걸렸는데 반복문 깨는 조건 잘못된줄 알고 헤맨거 ㄹㅇ 바보 ㅜㅜ
// 그래도 다른 풀이 안보고 푼 첫 bfs문제!!!

class Solution {
    ArrayList <ArrayList<Integer>> graph = new ArrayList<>();    
    public int bfs (int x, int[] arr, int target) {
        // x는 인덱스를 나타냄
        Queue<Integer> q = new LinkedList<>();
        q.offer(+arr[x]);
        q.offer(-arr[x]);
        int ans = 0;
        while(true) {
            int y = q.poll();
            
            q.offer(y+arr[x+1]);
            q.offer(y-arr[x+1]);
            
            if (q.size()==Math.pow(2, arr.length)) {
               break; 
            }
            if (q.size()==Math.pow(2, x+2)) x++;
        }
        // 값 검사. target과 같은 경우 반환값에 1 더하기
        int size = q.size();
        for (int i = 0; i < size; i++) {
            if (q.poll() == target) {
                ans ++;
            }
        }
        return ans;
        
    }
    public int solution(int[] numbers, int target) {
        return bfs(0, numbers, target);
    }
}