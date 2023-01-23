class Solution {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
        char[] arr = s.toCharArray();
        int lp = 0, rp = 0;
        String answer = s.substring(0, 1);
        for (int i = 1; i < arr.length; i ++){
            String subAns = s.substring(i);
            for (int j = 0; j < i; j ++) {
                lp = j;
                rp = i;
                while (lp < rp) {
                    if (arr[lp] != arr[rp]) {
                        break;
                    } else {
                        lp++;
                        rp--;
                    }
                }
                if (lp >= rp){
                    subAns = s.substring(j, i);
                    System.out.println("i: " + i+ " substring: " + subAns);
                    break;
                }
            }
            answer = subAns.length() > answer.length() ? subAns : answer;
        }

        return answer;
    }
}