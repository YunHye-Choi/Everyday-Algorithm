import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strArr = s.split(" ");
        int [] arr = new int [strArr.length];
        for (int i = 0; i < strArr.length; i ++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int tmp : arr) {
            if (tmp > max) max = tmp;
            if (tmp < min) min = tmp;
        }
        answer += min + " "  + max;
        return answer;
    }
}