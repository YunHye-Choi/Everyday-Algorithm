class Solution {
    public int lengthOfLongestSubstring(String s) {
        // longest substring without repeating chars
        String[] ls = new String[s.length()];
            
        int ans = 0;
        if (!s.isEmpty()) {
            ls[0] = s.substring(0, 1);
            ans = Math.max(ans, ls[0].length());
        }
        
        for (int i = 1; i < s.length(); i++) {
            String sub = s.substring(i, i+1);
            if (ls[i-1].contains(sub)){
                ls[i] = ls[i-1].substring(ls[i-1].indexOf(sub) + 1) + sub;
            } else {
                ls[i] = ls[i-1] + sub;
            }
            ans = Math.max(ans, ls[i].length());
        }
        return ans;
    }
}
