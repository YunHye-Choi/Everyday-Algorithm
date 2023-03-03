class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = -1, end = 0;
        int cnt = -1;
        for (int i = 0 ; i < nums.length; i++) {
            if (nums[i] == target) {
                if (start == -1)
                    start = i;
                cnt ++;
            }
        }
        end = start == -1 ? -1 : start + cnt;
        int[] ans = {start, end};
        return ans;
    }
}