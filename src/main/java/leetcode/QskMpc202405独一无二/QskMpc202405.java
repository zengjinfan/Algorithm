package leetcode.QskMpc202405独一无二;

import java.util.*;

/**
 * @author Administrator
 * @date 2024/5/17 18:40
 */
class QskMpc202405 {

    public int maxDiffCnt(int[] ball1, int[] ball2) {
        int result = 0;
        Set<Integer> ball1Set = new HashSet<>();
        Set<Integer> ball2Set = new HashSet<>();
        Set<Integer> totalSet = new HashSet<>();
        for (int b : ball1) {
            ball1Set.add(b);
            totalSet.add(b);
        }
        for (int b : ball2) {
            ball2Set.add(b);
            totalSet.add(b);
        }
        int ballNum = ball1.length;
        //每个数组最多能贡献的不同数，不能超过自身的一半
        int ball1Supply = Math.min(ball1Set.size(), ballNum / 2);
        int ball2Supply = Math.min(ball2Set.size(), ballNum / 2);
        int totalSupply = ball1Supply + ball2Supply;
        result = Math.min(totalSet.size(), totalSupply);
        return result;
    }

    public static void main(String[] args) {
        QskMpc202405 qskMpc202405 = new QskMpc202405();
        int[] ball1, ball2;
        int result;
        //示例1：ball1 = [1,2,3,3], ball2 = [3,4,5,5]
        ball1 = new int[]{1, 2, 3, 3};
        ball2 = new int[]{3, 4, 5, 5};
        result = qskMpc202405.maxDiffCnt(ball1, ball2);
        System.out.println("答案4:" + result);

        //示例2：ball1 = [1,3,3,3], ball2 = [1,3,5,3]
        ball1 = new int[]{1, 3, 3, 3};
        ball2 = new int[]{1, 3, 5, 3};
        result = qskMpc202405.maxDiffCnt(ball1, ball2);
        System.out.println("答案3:" + result);

        //示例3：ball1 = [1,1,1,1], ball2 = [1,1,1,1]
        ball1 = new int[]{1, 1, 1, 1};
        ball2 = new int[]{1, 1, 1, 1};
        result = qskMpc202405.maxDiffCnt(ball1, ball2);
        System.out.println("答案1:" + result);

        ball1 = new int[]{7899, 8261, 9789, 120417, 15273, 16032, 16893, 19620};
        ball2 = new int[]{7899, 82361, 9789, 12047, 15273, 16032, 16893, 19620};
        result = qskMpc202405.maxDiffCnt(ball1, ball2);
        System.out.println("检查1:" + result);

        ball1 = new int[]{9825, 48079, 29185, 29614, 30959, 31105, 34563, 43576, 45716, 48079};
        ball2 = new int[]{48079, 48079, 29185, 29614, 48079, 31105, 48079, 43576, 48079, 48079};
        result = qskMpc202405.maxDiffCnt(ball1, ball2);
        System.out.println("检查2:" + result);

        ball1 = new int[]{48693, 54109, 50152, 54109, 54109, 54109, 54670, 54109, 54109, 54109, 70696, 54109, 73134, 54109, 54109, 54109};
        ball2 = new int[]{54670, 59501, 65709, 70253, 70696, 71500, 73134, 75817, 76133, 83730, 48693, 48942, 50152, 50315, 50505, 54109};
        result = qskMpc202405.maxDiffCnt(ball1, ball2);
        System.out.println("检查3:" + result);

        //自测用例
        ball1 = new int[]{4, 4, 4, 3, 5, 6};
        ball2 = new int[]{1, 1, 1, 2, 2, 2};
        result = qskMpc202405.maxDiffCnt(ball1, ball2);
        System.out.println("答案5:" + result);//答案5

        ball1 = new int[]{4, 4, 4, 3, 3, 3};
        ball2 = new int[]{1, 1, 1, 2, 2, 2};
        result = qskMpc202405.maxDiffCnt(ball1, ball2);
        System.out.println("答案4:" + result);//答案4

        ball1 = new int[]{4, 4, 4, 3, 3, 3};
        ball2 = new int[]{4, 4, 4, 3, 3, 3};
        result = qskMpc202405.maxDiffCnt(ball1, ball2);
        System.out.println("答案2:" + result);//答案2

        ball1 = new int[]{3, 3, 1, 2};
        ball2 = new int[]{4, 4, 1, 2};
        result = qskMpc202405.maxDiffCnt(ball1, ball2);
        System.out.println("答案4:" + result);//答案4

        ball1 = new int[]{4, 4, 1, 9, 3, 8};
        ball2 = new int[]{2, 2, 2, 2, 2, 2};
        result = qskMpc202405.maxDiffCnt(ball1, ball2);
        System.out.println("答案4:" + result);

        ball1 = new int[]{4, 4, 1, 9, 3, 8};
        ball2 = new int[]{4, 4, 2, 2, 2, 2};
        result = qskMpc202405.maxDiffCnt(ball1, ball2);
        System.out.println("答案5:" + result);

        ball1 = new int[]{1, 1, 2, 2, 3, 3};
        ball2 = new int[]{3, 3, 4, 4, 5, 5};
        result = qskMpc202405.maxDiffCnt(ball1, ball2);
        System.out.println("答案5:" + result);

    }

}
