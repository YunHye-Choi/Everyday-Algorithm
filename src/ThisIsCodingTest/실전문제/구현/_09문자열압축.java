class Solution {
    public int solution(String s) {
        int answer = s.length;
        // 1개 단위부터 압축 단위를 늘려가며 확인
        for (int step = 1; step < s.length/2+1; step++) {
            String compressed = ""; // 압축된 문자열 저장
            String prev = s.subString(0, step); // prev에는 이전 문자열을 저장
            int cnt = 1;
            
            // 단위(step)만큼 j를 증가시키며 prev와 sub를 비교
            for (int j = step; j < s.length(); j += step) {
                
                // [j:j+step]의 문자열을 sub에 저장
                String sub = ""; 
                for (int k = j; k < j + step; k++) {
                    if (k < s.length()) sub += s.charAt(k);
                }
                
                // sub과 prev와 동일하다면 압축 횟수 증가 
                // (step단위로 끊은 문자열이 반복되어서 압축하는 상황)
                if (prev.equals(sub)) cnt ++;
                
                // 아닌 경우, 압축횟수가 2 이상인 경우 압축 크기와 prev를 붙여서, 
                //                                아니면 prev만 붙여서 문자열에 추가
                else {
                    compressed += (cnt >= 2) ? cnt + prev : prev;
                    sub ="";
                    for (int k = j; k < j + step; k++) {
                        if (k < s.length()) sub += s.charAt(k);
                    }
                    prev = sub; // 다시 상태 초기화
                    cnt = 1;
                }
            }
            compressed += (cnt >= 2) ? cnt + prev : prev;
            
            // 최소길이로 answer를 업데이트
            answer = Math.min(answer, compressed.length());
        }
        return answer;
    }
}