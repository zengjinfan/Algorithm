package leetcode.按摩师;

public class Solution {
    public int massage(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int dp_0 = 0;
        int dp_1 = nums[0];
        int dp_0_temp;
        for (int i = 1; i < nums.length; i++) {
            dp_0_temp = dp_0;
            dp_0 = Math.max(dp_0, dp_1);
            dp_1 = Math.max(dp_0_temp + nums[i], dp_1);
        }
        return Math.max(dp_0, dp_1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1}; //4
        int[] nums2 = {2, 7, 9, 3, 1}; //12
        int[] nums3 = {2, 1, 4, 5, 3, 1, 1, 3}; //12
        System.out.println(new Solution().massage(nums2));
    }
}
