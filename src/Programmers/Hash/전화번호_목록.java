// 내 풀이
// class Solution {
//     public boolean solution(String[] phone_book) {
//         boolean answer = true;
//         int len = phone_book.length;
//         for (int i = 0; i < len - 1; i++) {
//             for (int j = i+1; j < len; j ++) {
                
//                 if(phone_book[i].length() < phone_book[j].length()) {
//                     int subLen = phone_book[i].length();
//                     if (phone_book[j].substring(0,subLen).equals(phone_book[i])) {
//                         answer = false;
//                         break;
//                     }
//                 } else if(phone_book[j].length() < phone_book[i].length()) {
//                     int subLen = phone_book[j].length();
//                     if (phone_book[i].substring(0,subLen).equals(phone_book[j])) {
//                         answer = false;
//                         break;
//                     }
//                 }
               
//             }
//             if(answer == false) break;
//         }
        
//         return answer;
//     }
// }

import java.util.*;

class Solution {
    public boolean solution(String [] phone_book) {
        boolean answer = true;
        
        // hash map 만들기
        HashMap<String,Integer> hm = new HashMap<>();
        
        // 모든 전화번호를 접두어의 후보에 포함
        for (int i = 0; i < phone_book.length; i++) {
            hm.put(phone_book[i], i);
        }
        
        // 해시맵에 저장된 접두어를 꺼내보며 전화번호의 앞부분과 일치하는지 비교
        for (int i = 0; i < phone_book.length; i++) {
            for(int j = 1; j < phone_book[i].length(); j++) {
                if (hm.containsKey(phone_book[i].substring(0, j))) return false;
            }
        }
        
        return answer;
    }
}