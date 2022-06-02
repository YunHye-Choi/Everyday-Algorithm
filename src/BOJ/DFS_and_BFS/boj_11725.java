//  https://www.acmicpc.net/problem/11725
import java.util.*;
public class boj_11725 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        
        int n = sc.nextInt();

        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for (int i = 1; i < n+1; i ++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i ++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n+1];
        int[] answer = new int [n+1];

        q.add(1);
        visit[1] = true;
        while(!q.isEmpty()) {
            int num = q.poll();
            for (int tmp: graph[num]) {
                if (!visit[tmp]) {
                    q.add(tmp);
                    visit[tmp] = true;
                    answer[tmp] = num;
                }
            }
        }

        for (int i = 2 ; i < n+1; i++) {
            System.out.println(answer[i]);
        }
    }
}