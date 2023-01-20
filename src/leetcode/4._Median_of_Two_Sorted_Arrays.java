class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] combined = new int[nums1.length + nums2.length];
        for (int i = 0 ; i < nums1.length; i ++) {
            combined[i] = nums1[i];
        }
        int j = 0;
        for (int i = nums1.length; i < combined.length; i ++) {
            combined[i] = nums2[j++];
        }
        Arrays.sort(combined);
        double ans = 0;
        int half = combined.length/2;
        if (combined.length % 2 == 0) {
            System.out.println(combined[half] + " " + combined[half-1]);
            ans = (combined[half-1]+combined[half])/2.0;
        } else {
            ans = combined[half];
        }
        return ans;
        
    }
}