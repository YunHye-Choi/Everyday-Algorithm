// 풀이 생각해낸 시간에 비해서 너무 오래걸림 ㅠㅠ
// 풀이가 맞는 것 같은데 오답이라면 인덱스 잘못 넣어줬을 확률 큼.
// 코드 들여다보거나 종이에 그리는 것 보다 디버깅이 빠르다!
// bfs이용
// https://www.acmicpc.net/problem/14888
import java.util.*;
class Node_ {
    long val;
    int[] op;
    int lev;

    public Node_(long val, int[] op, int lev){
        this.val = val;
        this.op = op.clone();
        this.lev = lev;
    }
    public String toString(){
        return "val: " + val + ", op: [" + op[0] + ", " + op[1]+ ", " + op[2]+ ", " + op[3] + "], lev " + lev;
    }
}
public class boj_14888 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] init_op = new int [4];
        
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++){
            init_op[i] = sc.nextInt();
        }

        Queue<Node_> q = new LinkedList<>();
        for(int i = 0; i < 4;i ++){
            long temp = 0;
            int[] op = init_op.clone();
            if (op[i] > 0){
                if (i == 0) {
                    temp = arr[0] + arr[1];
                } else if (i == 1) {
                    temp = arr[0] - arr[1];
                } else if (i == 2) {
                    temp = arr[0] * arr[1];
                } else if (i == 3) {
                    temp = arr[0] / arr[1];
                }
                op[i]--;
                Node_ node = new Node_(temp, op, 0);
                q.add(node);
                // System.out.println(node);
            }
        }
        ArrayList<Long> candi = new ArrayList<>();
        while (!q.isEmpty()){
           
            Node_ node = q.poll();
            if(node.lev == n-2) {
                candi.add(node.val);
            } else {
                for(int i = 0; i < 4;i ++){
                    long temp = node.val;
                    int idx = node.lev+1;
                    int[] op = node.op.clone();
                    if (op[i] > 0){
                        if (i == 0) {
                            temp += arr[idx+1];
                        } else if (i == 1) {
                            temp -= arr[idx+1];
                        } else if (i == 2) {
                            temp *= arr[idx+1];
                        } else if (i == 3) {
                            temp /= arr[idx+1];
                        }
                        op[i]--;
                        
                        Node_ node_new = new Node_(temp, op, idx);
                        q.add(node_new);
                        // System.out.println("i: " + i + "|" + node_new);
                    }
                }
            }
        }
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        for(Long l : candi){
            max = Math.max(max, l);
            min = Math.min(min, l);
        }

        System.out.println(max);
        System.out.println(min);
    }
}
