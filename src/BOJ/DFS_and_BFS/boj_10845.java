// https://www.acmicpc.net/problem/10845
// 로직은 걍 개쉬움
// 근데 Queue API를 아직도 너무 모른다. element()하면 맨 앞거 읽기만!
// 시간초과 이슈
// BufferedReader br = new BufferedReader (new InputStringReader(System.in));
// br.readLine(); 으로 받아야됨;;;개짱나

import java.util.*;
import java.io.*;
public class boj_10845 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = br.readLine();
        int t = Integer.parseInt(tmp);
        Queue<Integer> q = new LinkedList<>();
        ArrayList <Integer> ans = new ArrayList<>();
        int lastNum = -1;
        String[] cmds = new String[t];
        for (int i = 0; i < t; i ++) {
            cmds[i] = br.readLine();
        }
        for (int i = 0; i < t; i ++) {
            // push X: 정수 X를 큐에 넣는 연산이다.
            // pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
            // size: 큐에 들어있는 정수의 개수를 출력한다.
            // empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
            // front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
            // back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
            String cmdTmp[] = cmds[i].split(" ");
            
            if (cmdTmp.length == 1) {
                if (cmdTmp[0].equals("pop")) {
                    if (!q.isEmpty()) {
                        ans.add(q.poll());
                    } else {
                        ans.add(-1);
                    }
                    
                } else if (cmdTmp[0].equals("size")) {
                    ans.add(q.size());
                } else if (cmdTmp[0].equals("empty")) {
                    if (q.isEmpty()) {
                        ans.add(1);
                    } else {
                        ans.add(0);
                    }
                } else if (cmdTmp[0].equals("front")) {
                    if (!q.isEmpty()) {
                        ans.add(q.element());
                    } else {
                        ans.add(-1);
                    }
                } else if (cmdTmp[0].equals("back")) {
                    if (!q.isEmpty()) {
                        ans.add(lastNum);
                    } else {
                        ans.add(-1);
                    }
                } 
            } else {
                int n = Integer.parseInt(cmdTmp[1]);
                q.add(n);
                lastNum = n;
            }
        }
        for (int i : ans) {
            System.out.println(i);
        }
    }
}
