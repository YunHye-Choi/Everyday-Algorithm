class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String s = countAndSay(n-1);
        if (s.equals("1")) return "11";
        String ans = "";
        char curr = '\0', prev = s.charAt(0);
        int count = 1, say = prev - '0';
        for (int i = 1 ; i < s.length(); i ++) {
            curr = s.charAt(i);
            if (prev == curr) {
                count ++;
                
            } else {
                ans += count + "" + say;
                count = 1;
                say = curr-'0';
            }
            if (i == s.length()-1) {
                ans += count + "" + say;
            }
            prev = curr;
        }

        return ans;
        
    }
}