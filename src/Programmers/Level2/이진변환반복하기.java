class Solution {
    public int[] solution(String s) {
        char[] arr = s.toCharArray();
        int zeroRemoveCnt = 0;
        int binChangeCnt = 0;
        
        while(!s.equals("1")) {
            binChangeCnt ++;
            arr = s.toCharArray();
            int pzrc = 0;
            for (char c: arr) {
                if (c == '0') pzrc ++;
            }
            zeroRemoveCnt += pzrc;
            int sLength = arr.length - pzrc;
            s = Integer.toBinaryString(sLength);
        }
        
        int[] answer = {binChangeCnt, zeroRemoveCnt};
        
        return answer;
    }
}