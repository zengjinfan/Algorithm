package leetcode.QskMpc202303内存碎片整理;

import java.util.ArrayList;
import java.util.List;

public class QskMpc202303 {
    public int getTidyTimes(String memory) {
        int res = 0;
        char[] memoryArray = memory.toCharArray();
        int length = memoryArray.length;
        if (length > 1) {
            while (!isFinish(memoryArray)) {
                tidy(memoryArray);
                res++;
            }
//            System.out.println("memory = " + Arrays.toString(memoryArray));
        }
        return res;
    }

    private boolean isFinish(char[] memoryArray) {
        boolean meetZero = false;
        for (char c : memoryArray) {
            if (c == '0') {
                meetZero = true;
            }
            if (c == '1' && meetZero) {
                //已经遇到过0，又碰见1，则表示未完成
                return false;
            }
        }
        return true;
    }

    private void tidy(char[] memoryArray) {
        int length = memoryArray.length;
        char leftChar;
        char rightChar;
        List<Integer> removeIndexList = new ArrayList<>();
        for (int i = 0; i < length - 1; i++) {
            leftChar = memoryArray[i];
            rightChar = memoryArray[i + 1];
            if (leftChar == '0' && rightChar == '1') {
                removeIndexList.add(i + 1);
            }
        }
        if (removeIndexList.size() > 0) {
            for (Integer rmIndex : removeIndexList) {
                memoryArray[rmIndex] = '0';
                memoryArray[rmIndex - 1] = '1';
            }
        }
    }

    public static void main(String[] args) {
        QskMpc202303 qskMpc202303 = new QskMpc202303();
        int tidyTimes = qskMpc202303.getTidyTimes("01101");
        System.out.println(tidyTimes);

        tidyTimes = qskMpc202303.getTidyTimes("011010110110");
        System.out.println(tidyTimes);

        tidyTimes = qskMpc202303.getTidyTimes("1111100");
        System.out.println(tidyTimes);

        tidyTimes = qskMpc202303.getTidyTimes("11");
        System.out.println(tidyTimes);

        tidyTimes = qskMpc202303.getTidyTimes("111");
        System.out.println(tidyTimes);

        tidyTimes = qskMpc202303.getTidyTimes("1");
        System.out.println(tidyTimes);

        tidyTimes = qskMpc202303.getTidyTimes("000");
        System.out.println(tidyTimes);

        System.out.println("检查1");
        tidyTimes = qskMpc202303.getTidyTimes("01101010101010101010101010101011010110110");
        System.out.println(tidyTimes);

        System.out.println("检查2");
        tidyTimes = qskMpc202303.getTidyTimes("110111010101011101111101011101101010101110111011100011111011010110110");
        System.out.println(tidyTimes);

        System.out.println("检查3");
        tidyTimes = qskMpc202303.getTidyTimes("000001111001101010101010101111111000001111111111111000000000000011111111111111111111111111110000000000111");
        System.out.println(tidyTimes);
    }
}
