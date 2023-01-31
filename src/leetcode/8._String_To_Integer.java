class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        int i = 0;
        boolean isAns = false;
        for(i = 0; i < s.length(); i ++) {
            if (i == 0) {
                if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                    continue;
                }
            }
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                break;
            } else {
                isAns = true;
            }
        }
        int ans = 0;
        try {
            ans = isAns ? Integer.parseInt(s.substring(0, i)) : 0;
        } catch(Exception e) {
            if (s.startsWith("-")){
                ans = Integer.MIN_VALUE;
            } else {
                ans = Integer.MAX_VALUE;
            }
        }
        return ans;
    }
}