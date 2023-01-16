import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Arrays.sort(nums);
        int ansIdx1 = 0, ansIdx2 = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println(i + ", " + j);
                    ansIdx1 = i;
                    ansIdx2 = j;
                    int[] ans = {i, j};
                    return ans;
                }
            }
        }
        int[] ans = {ansIdx1, ansIdx2};
        return ans;
    }
}