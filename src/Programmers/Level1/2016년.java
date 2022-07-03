class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int sumDay = 5;
        for (int i = 1; i < a; i ++) {
            if(i == 1 || i == 3  || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                sumDay += 31;
            } else if(i == 4 || i == 6 || i == 9 || i == 11) {
                 sumDay += 30;
            } else{
                sumDay += 29;
            }
        }
        for (int i = 1; i <= b; i++) {
            sumDay++;
        }
        sumDay--;
        answer = day[sumDay%7];
        return answer;
    }
}