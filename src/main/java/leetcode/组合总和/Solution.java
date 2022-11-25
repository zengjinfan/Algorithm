package leetcode.组合总和;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, new LinkedList<>(), 0, 0, target);
        return res;
    }

    public void backtrack(int[] candidates, LinkedList<Integer> path, int start, int sum, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
        } else if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtrack(candidates, path, i, sum + candidates[i], target);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,7,6,3,5,1};
        int target = 9;
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.combinationSum(candidates, target);
        System.out.println(lists);
    }
}
