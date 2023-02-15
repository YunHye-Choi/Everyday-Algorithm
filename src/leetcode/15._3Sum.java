class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        if (nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length-2; i ++) {
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == 0)
                    set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if (sum < 0)
                    j++;
                else
                    k--;
            }
        }
        return new ArrayList<>(set);
    }
}