package leetcode.QskMpc202311获取最多的公仔玩具;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QskMpc202311 {
    List<List<Integer>> resultList = new ArrayList<>();
    int maxDollCount = -1;

    public int maxDollCount(List<Integer> dollList, int luckyNum) {
        Collections.sort(dollList);
        dfs(new ArrayList<>(), dollList, 0, luckyNum);
        System.out.println(resultList);
        return maxDollCount;
    }

    public void dfs(List<Integer> currentList, List<Integer> candidateList, int searchStart,
                    Integer target) {
        if (target == 0) {
            resultList.add(new ArrayList<>(currentList));
            maxDollCount = Math.max(maxDollCount, currentList.size());
            return;
        } else if (target < 0) {
            return;
        }

        for (int i = searchStart; i < candidateList.size(); i++) {
            Integer candidate = candidateList.get(i);
            if(i > searchStart && candidate.equals(candidateList.get(i - 1))){
                return;
            }
            currentList.add(candidate);
            dfs(currentList, candidateList, i + 1, target - candidate);
            currentList.remove(candidate);
        }
    }

    public static void main(String[] args) {
        Integer[] dollArr = {4, 3, 7};
        List<Integer> dollList = Arrays.asList(dollArr);
        int luckyNum = 7;
        int res = new QskMpc202311().maxDollCount(dollList, luckyNum);
        System.out.println(res);

        Integer[] dollArr2 = {1, 1, 2, 2, 3, 3};
        dollList = Arrays.asList(dollArr2);
        luckyNum = 6;
        res = new QskMpc202311().maxDollCount(dollList, luckyNum);
        System.out.println(res);

        Integer[] dollArr3 = {2, 2, 3, 3};
        dollList = Arrays.asList(dollArr3);
        luckyNum = 1;
        res = new QskMpc202311().maxDollCount(dollList, luckyNum);
        System.out.println(res);

        Integer[] dollArr4 = {6,5,4,3,2,1};
        dollList = Arrays.asList(dollArr4);
        luckyNum = 9;
        res = new QskMpc202311().maxDollCount(dollList, luckyNum);
        System.out.println("检查1：" + res);

        Integer[] dollArr5 = {2,2,3,3,4,4,5,5,6,8,9,10,12,13,15,17,16,22,15,13,16};
        dollList = Arrays.asList(dollArr5);
        luckyNum = 55;
        res = new QskMpc202311().maxDollCount(dollList, luckyNum);
        System.out.println("检查2：" + res);

        Integer[] dollArr6 = {7,4,7,2,9,2,9,7,1,5,8,5,8,5,3,6,6,7,8,1,1,6,2,1,6,4,9,8,7,5,6,2,8,8,1,8,2,8,1,4,7,5,3,8,7,7,6,2,1,4,4,1,8,3,9,3,9,1,9,8,2,5,1,4,3,4,6,6,8,8,4,1,9,5,2,5,5,2,5,2,6,2,6,9,8,6,6,9,2,9,6,1,5,1,8,1,1,8,1,9,2,8,8,1,1,7,7,4,9};
        dollList = Arrays.asList(dollArr6);
        luckyNum = 66;
        res = new QskMpc202311().maxDollCount(dollList, luckyNum);
        System.out.println("检查3：" + res);
    }

    /*
    * 重要提示：
    - 1 <= n <= 1000
    - 1 <= dollList[i] <= 1000
    - 1 <= luckyNum <= 1000
    示例1：
    输入：dollList = [4,3,7], luckyNum = 7
    输出： 2
    解释：你可以拿走3,4这两个数字号牌对应的公仔，这样可以最多拿走2个公仔， 你选择7这个数字号牌只能拿走1个公仔
    示例2：
    输入：dollList = [1,1,2,2,3,3], luckyNum = 6
    输出：4
    示例3：
    输入：dollList = [2,2,3,3], luckyNum = 1
    输出：-1
    *
    检查1：
    输入：dollList = [6,5,4,3,2,1], luckyNum = 9
    检查2：
    输入：dollList = [2,2,3,3,4,4,5,5,6,8,9,10,12,13,15,17,16,22,15,13,16], luckyNum = 55
    检查3：
    输入：dollList = [7,4,7,2,9,2,9,7,1,5,8,5,8,5,3,6,6,7,8,1,1,6,2,1,6,4,9,8,7,5,6,2,8,8,1,8,2,8,1,4,7,5,3,8,7,7,6,2,1,4,4,1,8,3,9,3,9,1,9,8,2,5,1,4,3,4,6,6,8,8,4,1,9,5,2,5,5,2,5,2,6,2,6,9,8,6,6,9,2,9,6,1,5,1,8,1,1,8,1,9,2,8,8,1,1,7,7,4,9], luckyNum = 66

    * * */
}
