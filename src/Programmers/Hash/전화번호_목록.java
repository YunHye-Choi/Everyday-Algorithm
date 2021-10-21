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

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean solution(String[] phone_book){
        boolean answer = true;
        
        // 1. HashMap 만들기
        HashMap<String, Integer> map = new HashMap<>();
        
        // 2. 모든 전화번호로 hashing(==해시맵에추가)하기
        for(int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i],i);
        }
        
        // 3. 다시 돌며 각 전화번호의 일부가 해시맵에 있는지 탐색
        // phone_book[i]가 '포함하는', 해쉬셋의 값이 '포함되는' 값이라고 생각하기
        for(int i = 0; i < phone_book.length; i ++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0,j))) {
                    return false;
                }
            }
        }
        return true;
    }
}