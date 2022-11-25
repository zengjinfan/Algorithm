package leetcode.无重复字符的最长子串;

import java.util.Arrays;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] occ = new int[128];
        Arrays.fill(occ, 0);
        int length = s.length();
        int maxLen = 0;
        int start = 0;
        int end = 1;
        while (start < length) {
            while (end <= length) {
                char tempChar = s.charAt(end - 1);
                if (occ[tempChar] == 1) {
                    break;
                }
                occ[tempChar]++;
                int tempLen = end - start;
                if (tempLen > maxLen) {
                    maxLen = tempLen;
                }
                end++;
            }
            if(occ[s.charAt(start)] > 0){
                occ[s.charAt(start)]--;
            }
            start++;
        }
        return maxLen;
    }

//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        int len = nums.length;
//        if (len == 0) {
//            return res;
//        }
//        Stack<Integer> stack = new Stack<>();
//        dfs(nums, 0, len, stack, res);
//        return res;
//    }
//
//    private void dfs(int[] nums, int index, int len,
//                     Stack<Integer> stack, List<List<Integer>> res) {
//        if (index == len) {
//            res.add(new ArrayList<>(stack));
//            return;
//        }
//        // 当前数可选，也可以不选
//        // 选了有，进入下一层
//        stack.add(nums[index]);
//        dfs(nums, index + 1, len, stack, res);
//        stack.pop();
//
//        // 不选，直接进入下一层
//        dfs(nums, index + 1, len, stack, res);
//    }
//

//    List<List<Integer>> res = new ArrayList<>();
//    public List<List<Integer>> subsets(int[] nums) {
//        Deque<Integer> path = new ArrayDeque<>();
//        dfs(nums, 0, path);
//        return res;
//    }
//
//    void dfs(int[] nums, int begin, Deque<Integer> path){
//        res.add(new ArrayList<>(path));
//        if(path.size() == nums.length) return;
//
//        for(int i = begin; i < nums.length; i++){
//            path.add(nums[i]);
//            dfs(nums, i+1, path);
//            path.removeLast();
//        }
//    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("p"));
    }
}
