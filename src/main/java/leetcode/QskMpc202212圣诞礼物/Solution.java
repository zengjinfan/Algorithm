package leetcode.QskMpc202212圣诞礼物;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    private int ans = Integer.MAX_VALUE;

    public void dfs(int index, int[] v, int n, int k, int[] cookies){
        if (index == n){
            int maxv = 0;
            for (int i = 0; i < k; ++i){
                maxv = Math.max(maxv, v[i]);
            }
            ans = Math.min(maxv, ans);
            return;
        }

        for (int i = 0; i < k; ++i){
            if(v[i] + cookies[index] >= ans) continue;
            v[i] += cookies[index];
            dfs(index + 1, v, n, k, cookies);
            v[i] -= cookies[index];
        }
    }

    public int distributeCookies(int[] cookies, int k) {
        Arrays.sort(cookies);
        int middle;
        for (int i = 0; i < cookies.length / 2; i++) {
            middle = cookies[i];
            cookies[i] = cookies[cookies.length - i - 1];
            cookies[cookies.length - i - 1] = middle;
        }
        dfs(0, new int[k], cookies.length, k, cookies);
        return ans;
    }
}
