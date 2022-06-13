// 내가 푼 정답
import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int idx = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while (true) {
            char c = s.charAt(idx);
            if ('0' <= c && c <= '9') {
                arr.add(c - '0');
                idx++;
            } else {
                int num = 0;
                if (c == 'z') {
                    num = 0;
                    idx += 4;
                } else if (c == 'o') {
                    num = 1;
                    idx += 3;
                } else if (c == 't') {
                    char c2 = s.charAt(idx + 1);
                    if (c2=='w') { //two
                        num = 2;
                        idx += 3;
                    } else {
                        num = 3;
                        idx += 5;
                    }
                } else if (c == 'f') {
                    char c2 = s.charAt(idx + 1);
                    if (c2=='o') { //four
                        num = 4;
                        idx += 4;
                    } else {
                        num = 5;
                        idx += 4;
                    }
                } else if (c == 's') {
                    char c2 = s.charAt(idx + 1);
                    if (c2=='i') { //six
                        num = 6;
                        idx += 3;
                    } else {
                        num = 7;
                        idx += 5;
                    }
                } else if (c == 'e') {
                    num = 8;
                    idx += 5;
                } else {
                    num = 9;
                    idx += 4;
                }
                arr.add(num);
            }
            if (idx >= s.length()) {
                break;
            }
        }
        
        int cnt = arr.size() - 1;
        for (int tmp : arr) {
            answer += tmp * Math.pow(10, cnt--);
        }
        return answer;
    }
}
 /** 다른 사람의 풀이
  * 
  * "replaceAll()"의 빼어난 활용예!
import java.util.*;
class Solution {
    public int solution(String s) {
        String[] word = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        
        for(int i = 0; i < 10; i++) {
            s = s.replaceAll(word[i], num[i]);
        }
        
        return Integer.parseInt(s);
    }
}
  */