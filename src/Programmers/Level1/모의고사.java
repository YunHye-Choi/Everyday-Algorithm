import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        int a = 0, b = 0, c = 0;
        // 수포자 a
        for (int i = 0; i < answers.length;i ++) {
            if (i%5 == 0) {
                if (answers[i] == 1) a++;
            } else if (i%5 == 1) {
                if (answers[i] == 2) a++;
            } else if (i%5 == 2) {
                if (answers[i] == 3) a++;
            } else if (i%5 == 3) {
                if (answers[i] == 4) a++;
            } else if (i%5 == 4) {
                if (answers[i] == 5) a++;
            }
        }
        
        
        // 수포자 b
        for (int i = 0; i < answers.length;i ++) {
            if (i%2 == 0) {
                if (answers[i] == 2) b++;
            } else if (i%7 == 1) {
                if (answers[i] == 1) b++;
            } else if (i%7 == 3) {
                if (answers[i] == 3) b++;
            } else if (i%7 == 5) {
                if (answers[i] == 5) b++;
            }
        }
        
        // 수포자 c
        for (int i = 0; i < answers.length;i ++) {
            if (i%10 == 0 || i%10 == 1) {
                if (answers[i] == 3) c++;
            } else if (i%10 == 2 || i%10 == 3) {
                if (answers[i] == 1) c++;
            } else if (i%10 == 4 || i%10 == 5) {
                if (answers[i] == 2) c++;
            } else if (i%10 == 6 || i%10 == 7) {
                if (answers[i] == 4) c++;
            } else if (i%10 == 8 || i%10 == 9) {
                if (answers[i] == 5) c++;
            }
        }
        
        int max = Math.max(a, b);
        max = Math.max(b, c);
        max = Math.max(a, c);
        
        if (a == max) arr.add(1);
        if (b == max) arr.add(2);
        if (c == max) arr.add(3);
        
        Collections.sort(arr);
        int[] answer = new int[arr.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = arr.get(i);
            System.out.println(answer[i]);
        }

        
        return answer;
    }
}