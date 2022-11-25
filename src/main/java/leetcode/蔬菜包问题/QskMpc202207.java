package leetcode.蔬菜包问题;

import java.util.SortedMap;
import java.util.TreeMap;

class QskMpc202207 {

    public int maxVegetableDays(int[] vegetables, int[] effective) {
        int res = 0;
        int totalDay = vegetables.length;
        if (totalDay == 0) {
            return res;
        }
        int curDay = 0;
        //最后有效日期，蔬菜包数量
        SortedMap<Integer, Integer> validDayVegetablesNumMap = new TreeMap<>();
        while (curDay < totalDay || !validDayVegetablesNumMap.isEmpty()) {
            if (curDay < totalDay && vegetables[curDay] > 0) {
                //计算最后有效日期
                int validDay = curDay + effective[curDay] - 1;
                //获取最后有效日期对应的蔬菜包数量
                Integer vegetablesNum = validDayVegetablesNumMap.getOrDefault(validDay, 0);
                //累加最后有效日期对应的蔬菜包数量
                validDayVegetablesNumMap.put(validDay, vegetablesNum + vegetables[curDay]);
            }
            //取还未过期的蔬菜包
            validDayVegetablesNumMap = validDayVegetablesNumMap.tailMap(curDay);
            if (!validDayVegetablesNumMap.isEmpty()) {
                //从上面还未过期的蔬菜包中取最早过期的蔬菜包
                Integer validDay_0 = validDayVegetablesNumMap.firstKey();
                Integer vegetablesNum_0 = validDayVegetablesNumMap.get(validDay_0);
                //过期日期对应的蔬菜包数量大于0，说明当天有蔬菜包吃
                if (vegetablesNum_0 > 0) {
                    res++;
                }
                if (--vegetablesNum_0 > 0) {
                    //蔬菜包数量减1
                    validDayVegetablesNumMap.put(validDay_0, vegetablesNum_0);
                } else {
                    //蔬菜包数量减到0，则移除
                    validDayVegetablesNumMap.remove(validDay_0);
                }
            }
            curDay++;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] vegetables = {1, 0, 4};
//        int[] effective = {2, 0, 1};  //2

//        int[] vegetables = {1, 2, 3};
//        int[] effective = {2, 2, 5};  //6

//        int[] vegetables = {4, 2, 5};
//        int[] effective = {4, 1, 6};  //8

        //检查1
//        int[] vegetables = {1,2,3,4,5,6,7,0,8};
//        int[] effective = {3,3,2,1,3,2,3,0,6};  //14

        //检查2
//        int[] vegetables = {32,21,100,68,18,102,88,65,39,92,75,0,43};
//        int[] effective = {13,11,43,12,45,16,37,13,22,79,32,0,63};  //88

        //检查3
        int[] vegetables = {22, 21, 24, 23, 25, 0, 26, 29, 28, 30, 31, 32, 0, 35, 34, 36, 37, 39, 38, 41, 40, 42, 43, 44, 46, 45, 48, 47, 49, 51, 50, 52, 53, 55, 54, 56, 57, 58, 59, 60, 61, 63, 62, 64, 66, 65, 67, 69, 68, 71, 70, 72, 74, 73, 76, 75, 77, 78, 79, 80, 81, 82, 83, 85, 84, 86, 87, 88, 90, 89, 91, 92, 93, 94, 96, 95, 98, 97, 99, 100, 101, 102, 103, 104, 105, 107, 106, 108, 109, 110, 111, 112, 114, 113, 116, 115, 117, 119, 118, 120, 121, 122, 124, 0, 126, 125, 128};
        int[] effective = {5, 4, 7, 6, 9, 0, 10, 12, 11, 13, 15, 14, 0, 18, 17, 19, 20, 22, 21, 24, 23, 25, 27, 26, 29, 28, 30, 31, 32, 33, 35, 34, 36, 37, 39, 38, 41, 40, 42, 43, 44, 46, 45, 48, 47, 49, 51, 50, 52, 53, 55, 54, 56, 57, 58, 59, 60, 61, 63, 62, 64, 66, 65, 67, 69, 68, 71, 70, 72, 74, 73, 76, 75, 77, 78, 79, 80, 81, 82, 83, 85, 84, 86, 87, 88, 90, 89, 91, 92, 93, 94, 96, 95, 98, 97, 99, 100, 101, 102, 103, 104, 105, 107, 0, 108, 107, 109};
        //215

        QskMpc202207 qskMpc202207 = new QskMpc202207();
        int res = qskMpc202207.maxVegetableDays(vegetables, effective);
        System.out.println(res);
    }


}
