package leetcode.增减字符串匹配;

public class Solution {

    public int[] diStringMatch(String s) {
        int len = s.length();
        int l = 0;
        int r = len;
        int index = 0;
        int[] perm = new int[len + 1];
        for (char c : s.toCharArray()) {
            if(c == 'D'){
                perm[index++] = r--;
            }else if(c == 'I'){
                perm[index++] = l++;
            }
        }
        perm[index] = r;
        return perm;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i : solution.diStringMatch("ID")) {
            System.out.print(i + ",");
        }
    }
}
