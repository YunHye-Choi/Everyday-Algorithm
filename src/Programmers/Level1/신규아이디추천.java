// 문자열 메서드 복습 용 문제. 정규형을 이용한 풀이까지 익혀보자!
// 일단 내 코드 잘못된점 찾기 (테케 2개 통과못함)
// ㄴ 잘안되면 풀이 참고하기: https://minhamina.tistory.com/121
class Solution {
    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();
        char[] arr = new_id.toCharArray();
        
        for(int i = 0 ; i < arr.length; i++) {
            if(!('a' <= arr[i] && arr[i]<='z') && !('0' <= arr[i] && arr[i]<='9')
              && arr[i] != '.' && arr[i] != '-' && arr[i] != '_') {
                String target = Character.toString(arr[i]);
                new_id = new_id.replace(target, "");
            }
        }
        
        arr = new_id.toCharArray();
        String dots = ".";
        boolean prevDot = false;
        for(int i = 1 ; i < arr.length; i++) {
            if (arr[i-1] == '.' && arr[i] == '.') {
                System.out.println(arr[i-1] + " vs " + arr[i]);
                dots += ".";
                prevDot = true;
                if (i == arr.length-1) {
                    new_id = new_id.replace(dots, ".");
                }
            } else {
                if (prevDot) {
                    new_id = new_id.replace(dots, ".");
                    dots=".";
                    prevDot = false;
                }
            }
        }
        
        arr = new_id.toCharArray();
        if (arr[0] == '.'){
            if(arr.length >= 1)
                new_id = new_id.substring(1);
        }
        arr = new_id.toCharArray();
        if (arr.length >= 1) {
            if (arr[arr.length-1] == '.'){
                if(new_id.length() >= 1) {
                    new_id = new_id.substring(0, new_id.length()-1);
                }
                else new_id = "";
            }
        }
        if (new_id.length() == 0) {
            new_id = "a";
        }
        if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
            
        }
        arr = new_id.toCharArray();
        if (arr[new_id.length()-1] == '.') {
            new_id = new_id.substring(0, new_id.length()-1);
        }
        
        arr = new_id.toCharArray();
        if (new_id.length() < 3) {
            String last = Character.toString(arr[new_id.length()-1]);
            while (new_id.length() < 3) {
                new_id += last;
            }
        }
        answer = new_id;
        return answer;
    }
}