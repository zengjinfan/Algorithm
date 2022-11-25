package leetcode.分糖果;

import java.util.HashSet;
import java.util.Set;

public class Solution {


    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet();
        int n = candyType.length;
        int allow = n / 2;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!set.contains(candyType[i]) && count < allow) {
                set.add(candyType[i]);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3};
        Solution solution = new Solution();
        System.out.println(solution.distributeCandies(nums));
    }
}
