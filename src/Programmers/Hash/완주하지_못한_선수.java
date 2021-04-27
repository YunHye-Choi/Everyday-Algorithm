import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int i = 0;
        Arrays.sort(participant);
        Arrays.sort(completion);
        for (String p: participant) {
            if (!p.equals(completion[i])) break;
            
            i++;
            if (i == completion.length) break;
        }
        answer = participant[i];
        return answer;
    }
}