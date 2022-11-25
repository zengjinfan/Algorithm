package leetcode.子集;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）
 */
public class Solution {
    static List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, new LinkedList<>(), 0);
        return res;
    }

    public void backtrack(int[] nums, LinkedList<Integer> path, int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, path, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        Solution solution = new Solution();
        solution.subsets(array);
        System.out.println(res);

    }
}
