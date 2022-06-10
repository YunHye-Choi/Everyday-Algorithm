// https://programmers.co.kr/learn/courses/30/lessons/92334
// 풀이참고: https://jangcenter.tistory.com/116
// 자바 자료구조 다시 싹 정리하고 공부하자

import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // 나를 신고한 사람을 저장하는 HashSet을 value로 가지는 HashMap..!
        // 내가 신고한 사람을 저장하면, 메일 대상 선정 시 모든 hashSet 다 뒤져야 함.
        // 나를 신고한 사람을 저장하면, 신고건수와 신고인을 한번에 관리 가능
        Map<String, HashSet<String>> map = new HashMap<>();
        Map<String, Integer> idxMap = new HashMap<>();
        
        for (int i = 0; i < id_list.length; i++) {
            idxMap.put(id_list[i], i);
            map.put(id_list[i], new HashSet<>());
        }
        
        for (int i = 0; i < report.length; i++) {
            String[] s = report[i].split(" ");
            map.get(s[1]).add(s[0]);
        }
        
        // i번째 사람 신고한 사람 누군지 조사해서 해당 인덱스에 가산
        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> send = map.get(id_list[i]);
            if(send.size() >= k) {
                // 이러면 자동으로 키값들만 가져오는구나~
                for (String name: send) {
                    answer[idxMap.get(name)] ++;
                }
            }
        }
        
        return answer;
    }
}