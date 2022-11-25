package leetcode.子集II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可能 包含重复元素 的整数数组 nums，返回该数组所有可能的子集（幂集）。
 输入: [1,2,2]
 输出:
 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
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
            if(i > start && nums[i] == nums[i - 1]){
                continue;
            }
            path.add(nums[i]);
            backtrack(nums, path, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 1, 2};
        //排序，为剪枝判断做准备
        Arrays.sort(array);

        Solution solution = new Solution();
        solution.subsets(array);
        System.out.println(res);

    }
}

