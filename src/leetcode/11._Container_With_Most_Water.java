class Solution {
    public int maxArea(int[] height) {
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < height.length; i++) {
            for (int j = 0; j < i; j++ ) {
                if (height[j] < height[i]) {
                    ans = Math.max(height[j] * Math.abs(i-j), ans);
                }
                else {
                    ans = Math.max(height[i] * Math.abs(i-j), ans);
                    break;
                }
            }
            System.out.println(ans);
        }
        return ans;
    }
}
