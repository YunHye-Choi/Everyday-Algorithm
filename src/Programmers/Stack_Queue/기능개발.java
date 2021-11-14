import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // int[] answer = new int[progresses.length];
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> prg = new LinkedList<Integer>();
        for (int i = 0; i < progresses.length; i++ ) {
            prg.add(progresses[i]);
        }
        int day = 0;
        int index = 0;
        int doneProc = 0;
        while(true) {
            day++;
            if(prg.peek()+speeds[index] * day >= 100) {
                prg.poll();
                doneProc++;
                while(true) {
                    index++;
                    if (prg.isEmpty()) break;
                    if (prg.peek()+speeds[index] * day >= 100) {
                        prg.poll();
                        doneProc++;
                    } else {
                        break;
                    }
                }
                ans.add(doneProc);
                doneProc=0;
            } 
            if (prg.isEmpty()) break;
        }
        int answer[] = new int[ans.size()];
        int i = 0;
        for(int temp : ans) {
            answer[i++] = temp;
        }
        return answer;
    }
}