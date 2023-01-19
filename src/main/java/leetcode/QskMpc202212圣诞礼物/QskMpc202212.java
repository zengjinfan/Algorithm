package leetcode.QskMpc202212圣诞礼物;

import java.util.Arrays;

public class QskMpc202212 {

    private int ans = Integer.MAX_VALUE;

    public int minMaxSugers(int[] sugerList, int k){
        Arrays.sort(sugerList);
        int middle;
        for (int i = 0; i < sugerList.length / 2; i++) {
            middle = sugerList[i];
            sugerList[i] = sugerList[sugerList.length - i - 1];
            sugerList[sugerList.length - i - 1] = middle;
        }
        dfs(0, sugerList, new int[k]);
        return ans;
    }

    public void dfs(int index, int[] sugerList, int[] divideList) {
        int n = sugerList.length;
        int k = divideList.length;
        if (index == n) {
            int max = Arrays.stream(divideList).max().getAsInt();
            ans = Math.min(max, ans);
            return;
        }
        for (int i = 0; i < k; i++) {
            if (divideList[i] + sugerList[index] >= ans) {
                continue;
            }
            divideList[i] += sugerList[index];
            dfs(index + 1, sugerList, divideList);
            divideList[i] -= sugerList[index];
        }
    }

    public static void main(String[] args) {
        int[] sugerList1 = {1,2,4};
        int k1 = 2;
        int ans = new QskMpc202212().minMaxSugers(sugerList1, k1);
        System.out.println(ans);

        int[] sugerList2 = {1,2,3,4,5,6};
        int k2 = 3;
        int ans2 = new QskMpc202212().minMaxSugers(sugerList2, k2);
        System.out.println(ans2);

        int[] sugerList3 = {10,21,23,14,5,6,6,10};
        int k3 = 4;
        int ans3 = new QskMpc202212().minMaxSugers(sugerList3, k3);
        System.out.println(ans3);

        //输入：sugerList = [115,21,87,214,158,61,61,140], k=3
        int[] sugerList4 = {115,21,87,214,158,61,61,140};
        int k4 = 3;
        int ans4 = new QskMpc202212().minMaxSugers(sugerList4, k4);
        System.out.println("检查1: " + ans4);

        //输入：sugerList = [213,1217,597,1143,1538,611,961,1324], k=4
        int[] sugerList5 = {213,1217,597,1143,1538,611,961,1324};
        int k5 = 4;
        int ans5 = new QskMpc202212().minMaxSugers(sugerList5, k5);
        System.out.println("检查2: " + ans5);

        //输入：sugerList = [8213,7217,5587,3143,5576,6888,9121,7777], k=3
        int[] sugerList6 = {8213,7217,5587,3143,5576,6888,9121,7777};
        int k6 = 3;
        int ans6 = new QskMpc202212().minMaxSugers(sugerList6, k6);
        System.out.println("检查3: " + ans6);
        /**
         * 示例1：
         * 输入：sugerList = [1,2,4], k=2
         * 输出：4
         * 解释：最优的方案是(1,2)和(4)， 此时最大值最小为4， 其他的方案最大值都大于4
         * 示例2：
         * 输入：sugerList = [1,2,3,4,5,6], k=3
         * 输出：7
         * 解释：最优的方案是(1,6),(2,5)和(3,4)， 此时最大值最小为7， 其他的方案最大值都大于7
         * 示例3：
         * 输入：sugerList = [10,21,23,14,5,6,6,10], k=4
         * 输出：26
         * 检查1：
         * 输入：sugerList = [115,21,87,214,158,61,61,140], k=3
         * 检查2：
         * 输入：sugerList = [213,1217,597,1143,1538,611,961,1324], k=4
         * 检查3：
         * 输入：sugerList = [8213,7217,5587,3143,5576,6888,9121,7777], k=3
         */
    }
}
