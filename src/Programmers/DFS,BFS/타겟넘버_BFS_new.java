// 뭐 이렇게도 풀 수는 있다.
// dfs 풀이...아쉽다.
import java.util.*;
class Edge {
    int lev;
    int sum;
    
    public Edge(int l, int s) {
        lev = l;
        sum = s;
    }
}
class Solution {
    public static int [] nums;
    public static boolean [] visit;
    public static int tar;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        nums = numbers;
        tar = target;
        
        Queue<Edge> q = new LinkedList<>();
        q.add(new Edge(0, -numbers[0]));
        q.add(new Edge(0, numbers[0]));
        while(!q.isEmpty()) {
            Edge e = q.poll();
            if (e.lev == numbers.length - 1){
                if (e.sum == target) answer ++;                   
            } else {
                q.add(new Edge(e.lev + 1, e.sum - numbers[e.lev + 1]));
                q.add(new Edge(e.lev + 1, e.sum + numbers[e.lev + 1]));
            }
        }        
        
        return answer;
    }
    
}
