package leetcode.爱吃香蕉的珂珂;

/**
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有piles[i]根香蕉。警卫已经离开了，将在 h 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。
 * 如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * <p>
 * <p>
 * 示例 1：
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 * <p>
 * 示例 2：
 * 输入：piles = [30,11,23,4,20], h = 5
 * 输出：30
 * <p>
 * 示例 3：
 * 输入：piles = [30,11,23,4,20], h = 6
 * 输出：23
 * <p>
 * 提示：
 * 1 <= piles.length <= 104
 * piles.length <= h <= 109
 * 1 <= piles[i] <= 109
 */
public class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int pile : piles) {
            if (pile > maxPile) {
                maxPile = pile;
            }
        }
        //二分查找法，最小速度是1，最大速度取最大堆的速度
        int left = 1;
        int right = maxPile;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int needHours = 0;
            for (int pile : piles) {
                needHours += (pile - 1) / mid  + 1;
            }
            if (needHours <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {16};
        Solution solution = new Solution();
        System.out.println(solution.minEatingSpeed(nums, 8));
    }

}
