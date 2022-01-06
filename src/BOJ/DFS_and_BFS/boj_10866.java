// ArrayList API :  add(int index, E obj) >> LinkedList처럼 밀어넣기 된다는 사실!
// https://www.acmicpc.net/problem/10866
// 오타오타오타..! 잘 좀 보자
import java.io.*;
import java.util.*;
public class boj_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = br.readLine();
        int t = Integer.parseInt(tmp);
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        while (t-- != 0) {
            tmp = br.readLine();
            String []cmds = tmp.split(" ");
            if(cmds.length == 1) {
                if (cmds[0].equals("pop_front")) {
                    if(!arr.isEmpty()) {
                        ans.add(arr.remove(0));
                    } else {
                        ans.add(-1);
                    }
                } else if (cmds[0].equals("pop_back")) {
                    if(!arr.isEmpty()) {
                        ans.add(arr.remove(arr.size()-1));
                    } else {
                        ans.add(-1);
                    }
                    
                } else if (cmds[0].equals("size")) {
                    ans.add(arr.size());
                } else if (cmds[0].equals("empty")) {
                    if(arr.isEmpty()) {
                        ans.add(1);
                    } else {
                        ans.add(0);
                    }
                    
                } else if (cmds[0].equals("front")) {
                    if(!arr.isEmpty()) {
                        ans.add(arr.get(0));
                    } else {
                        ans.add(-1);
                    }
                    
                } else if (cmds[0].equals("back")) {
                    if(!arr.isEmpty()) {
                        ans.add(arr.get(arr.size()-1));
                    } else {
                        ans.add(-1);
                    }
                }

            } else {
                int num = Integer.parseInt(cmds[1]);
                if (cmds[0].equals("push_front")) {
                    arr.add(0, num);
                } else if(cmds[0].equals("push_back")) {
                    arr.add(num);
                }
            }
        } 
        for (int i : ans) {
            System.out.println(i);
        }
    }
}
