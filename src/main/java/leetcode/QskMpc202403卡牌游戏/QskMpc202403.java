package leetcode.QskMpc202403卡牌游戏;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class QskMpc202403 {

    public int maxScore(int[] cards) {
        Arrays.sort(cards);
        int res = 0;
        for (int p = 0; p < cards.length; p++) {
            //取离当前元素最近且比当前元素大的元素
            if (cards[p] > cards[res]) {
                res++;
            }
        }

//        int[] printCards = new int[cards.length];
//        int tailIndex = cards.length - 1;
//        for (int p = 0; p < cards.length; p++) {
//            //取离当前元素最近且比当前元素大的元素
//            if (cards[p] > cards[res]) {
//                printCards[res] = cards[p];
//                res++;
//            }else{
//                printCards[tailIndex--] = cards[p];
//            }
//        }
//        System.out.println(Arrays.toString(printCards));
        return res;
    }


    public static void main(String[] args) {
        QskMpc202403 qskMpc202403 = new QskMpc202403();
        int[] cards = {1, 2, 3};
        System.out.println(qskMpc202403.maxScore(cards));

        int[] cards2 = {1, 1, 3};
        System.out.println(qskMpc202403.maxScore(cards2));

        int[] cards3 = {3};
        System.out.println(qskMpc202403.maxScore(cards3));

        int[] cards4 = {1, 1, 1, 2, 2, 2, 3, 3, 3};
        System.out.println(qskMpc202403.maxScore(cards4));

        int[] cards5 = {31566,15749,11781,12037,53653,22231,34302,1902,12705,98077,7319,10481};
        System.out.println("检查1：" + qskMpc202403.maxScore(cards5));

        int[] cards6 = {8666,16912,48657,64962,57043,93592,20510,6926,23666,25801,77820,26072,6265,75052,4324,80369,3792,11111,52565,92053,8209,19968,85891,59028,89791,51435,71615,26160,27544,72039,37707,15737,49946,15689,57369,85636,81143,55076,69104,12402,29459,72988,71038,33398,61314,87202,951,5233,19524,49573};
        System.out.println("检查2：" + qskMpc202403.maxScore(cards6));

        int[] cards7 = {7899,8261,9789,12047,15273,16032,16893,19620,19825,19956,29185,29614,30959,31105,34563,43576,45716,48079,48693,48942,50152,50315,50505,54109,54670,59501,65709,70253,70696,71500,73134,75817,76133,83730,97796,15273,16032,16893,19620,19825,15273,16032,16893,19620,19825,15273,16032,16893,19620,19825};
        System.out.println("检查3：" + qskMpc202403.maxScore(cards7));
    }

}