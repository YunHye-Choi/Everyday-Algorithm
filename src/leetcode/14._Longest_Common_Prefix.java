class Solution {
    public String longestCommonPrefix(String[] strs) {
        int min = Integer.MAX_VALUE;
        String minStr = "";
        for (String s : strs) {
            if (min > s.length()) {
                minStr = s;
            }
        }
        String pre = "";
        boolean ans =  true;
        for (int i = 0 ; i < minStr.length(); i ++) {
            pre = minStr.substring(0, minStr.length()-i);
            System.out.println(pre);
            ans = true;
            for (String s : strs) {
                if (!s.startsWith(pre)) {
                    ans = false;
                    break;
                }
            }
            if (ans)
                break;
        }
        if (!ans) return "";
        return pre;
    }
}