class Solution {
    public boolean isPalindrome(int x) {
        String str = x + "";
        boolean answer = true;
        int len = str.length();
        for(int i = 0; i < len/2; i ++) {
            if (str.charAt(i) != str.charAt(len-i-1)) {
                answer = false;
            }
        }
        return answer;
    }
}