package leetcode.下一个更大元素II;

import java.util.Arrays;

public class Solution {
    public int[] nextBiggest(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int count = 0;
            if (j == nums.length) j = 0;
            boolean isFound = false;
            while (count < nums.length - 1) {
                if (nums[j] > nums[i]) {
                    res[i] = nums[j];
                    isFound = true;
                    break;
                }
                count++;
                j++;
                if (j == nums.length) j = 0;
            }
            if (!isFound) {
                res[i] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        Solution solution = new Solution();
        Arrays.stream(solution.nextBiggest(nums)).boxed().forEach(System.out::println);
    }
}
