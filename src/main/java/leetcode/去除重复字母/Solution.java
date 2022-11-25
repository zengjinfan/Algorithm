package leetcode.去除重复字母;

import java.util.*;

public class Solution {
    List<Character> ans = new ArrayList<>();
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> charPrePosition = new HashMap<>();
        char[] charArray = s.toCharArray();
        int[] charCount = new int[128];

        Arrays.fill(charCount, 0);
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            ans.add(c);
            charCount[c]++;
//            if(charCount[c] == 2){
//                doRemoveDuplicate(ans, c);
//                charCount[c]--;
//            }

        }
        for(int j = 127; j >=0; j--){
            int count = charCount[j];
            while (count > 1){
                doRemoveDuplicate(ans, (char)j);
                count--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : ans) {
            sb.append(c);
        }
        return sb.toString();
    }


    public void doRemoveDuplicate(List<Character> ans, char c) {
        boolean hasSmallestChar = false;
        int index = ans.indexOf(c);
        if(ans.get(index + 1) < c){
            hasSmallestChar = true;
        }
        if(hasSmallestChar){
            ans.remove(index);
        }else{
            int lastIndex = ans.lastIndexOf(c);
            ans.remove(lastIndex);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //cbacdcbc -> acdb
        //32134323 -> 1342
        //   dbcabc -> dabc
        //   bcab -> bca
        String newStr = solution.removeDuplicateLetters("acbacdcbc");
        System.out.println(newStr);
    }
}
