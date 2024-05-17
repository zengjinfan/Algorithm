package leetcode.QskMpc202405独一无二;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Administrator
 * @date 2024/5/17 18:40
 */
class QskMpc202405 {

    public int maxDiffCnt(int[] ball1, int[] ball2) {
        int result = 0;
        Map<Integer, Integer> totalCountMap = new HashMap<>();

        Map<Integer, Integer> ball1TreeCountMap = new HashMap<>();
        for (Integer ball : ball1) {
            ball1TreeCountMap.put(ball, ball1TreeCountMap.getOrDefault(ball, 0) + 1);
            totalCountMap.put(ball, totalCountMap.getOrDefault(ball, 0) + 1);
        }

        Map<Integer, Integer> ball2TreeCountMap = new HashMap<>();
        for (Integer ball : ball2) {
            ball2TreeCountMap.put(ball, ball2TreeCountMap.getOrDefault(ball, 0) + 1);
            totalCountMap.put(ball, totalCountMap.getOrDefault(ball, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : ball1TreeCountMap.entrySet()) {
            Integer value = Math.max(entry.getValue(), totalCountMap.get(entry.getKey()));
            ball1TreeCountMap.put(entry.getKey(), value);
        }

        for (Map.Entry<Integer, Integer> entry : ball2TreeCountMap.entrySet()) {
            Integer value = Math.max(entry.getValue(), totalCountMap.get(entry.getKey()));
            ball2TreeCountMap.put(entry.getKey(), value);
        }

//        System.out.println(ball1TreeCountMap);
//        System.out.println(ball2TreeCountMap);
//        System.out.println(totalCountMap);

        List<Map.Entry<Integer, Integer>> totalList = new ArrayList<>(totalCountMap.entrySet());
        totalList.sort(new ValueComparator());
        List<Map.Entry<Integer, Integer>> ball1List = new ArrayList<>(ball1TreeCountMap.entrySet());
        ball1List.sort(new ValueComparator());
        List<Map.Entry<Integer, Integer>> ball2List = new ArrayList<>(ball2TreeCountMap.entrySet());
        ball2List.sort(new ValueComparator());

        int ball1Num = ball1.length / 2;
        int count = 0;
        for (Map.Entry<Integer, Integer> ball1Entry : ball1List) {
            Integer value = ball1Entry.getValue();
            while (value > 0 && count < ball1Num) {
                count++;
                value--;
                if (value == 0) {
                    ball1TreeCountMap.remove(ball1Entry.getKey());
                } else {
                    ball1TreeCountMap.put(ball1Entry.getKey(), value);
                }
            }
        }

        int ball2Num = ball2.length / 2;
        count = 0;
        for (Map.Entry<Integer, Integer> ball2Entry : ball2List) {
            Integer value = ball2Entry.getValue();
            while (value > 0 && count < ball2Num) {
                count++;
                value--;
                if (value == 0) {
                    ball2TreeCountMap.remove(ball2Entry.getKey());
                } else {
                    ball2TreeCountMap.put(ball2Entry.getKey(), value);
                }
            }
        }

        for (Map.Entry<Integer, Integer> ball1Entry : ball1TreeCountMap.entrySet()) {
            Integer key = ball1Entry.getKey();
            if(ball2TreeCountMap.containsKey(key)){
                ball2TreeCountMap.put(key, ball1Entry.getValue());
            }
        }


        System.out.println("total = " + totalList);
        System.out.println("ball1 = " + ball1List);
        System.out.println("ball2 = " + ball2List);

        return result;
    }

    public static void main(String[] args) {
        QskMpc202405 qskMpc202405 = new QskMpc202405();

        //ball1 = [1,2,3,3], ball2 = [3,4,5,5]
        int[] ball1 = new int[]{1, 2, 3, 3};
        int[] ball2 = new int[]{3, 4, 5, 5};
        qskMpc202405.maxDiffCnt(ball1, ball2);

        ball1 = new int[]{3, 4};
        ball2 = new int[]{3, 3};
        qskMpc202405.maxDiffCnt(ball1, ball2);

    }

    class ValueComparator implements Comparator<Map.Entry<Integer, Integer>> {
        @Override
        //升序排序
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            return o1.getValue().compareTo(o2.getValue());
        }
    }
}
