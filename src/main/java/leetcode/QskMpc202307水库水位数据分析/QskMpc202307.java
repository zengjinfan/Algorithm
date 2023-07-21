package leetcode.QskMpc202307水库水位数据分析;

public class QskMpc202307 {

    public long getSectionCount(int[] waterList) {
        long n = waterList.length;
        long result = 0;
        for (int i = 0; i < n; i++) {
            for (int k = i; k < n; k++) {
                boolean r = isDesc(waterList, i, k);
                if (r) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean isDesc(int[] waterList, int start, int end) {
        int temp = waterList[start];
        for (int i = start + 1; i <= end; i++) {
            if (waterList[i] != temp - 1) {
                return false;
            } else {
                temp = waterList[i];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        QskMpc202307 qskMpc202307 = new QskMpc202307();
        int[] waterList = new int[]{1, 5, 4, 3, 4, 5};
        System.out.println("示例1:" + qskMpc202307.getSectionCount(waterList));

        waterList = new int[]{5, 3, 3, 4, 4, 5};
        System.out.println("示例2:" + qskMpc202307.getSectionCount(waterList));

        waterList = new int[]{8, 7, 6, 5, 4, 4, 3};
        System.out.println("示例3:" + qskMpc202307.getSectionCount(waterList));

        waterList = new int[]{3, 2, 1, 4, 3, 2, 1, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("检查1:" + qskMpc202307.getSectionCount(waterList));

        waterList = new int[]{18, 17, 16, 15, 14, 13, 12, 11, 10, 14, 13, 12, 11, 10, 10, 9, 8, 7};
        System.out.println("检查2:" + qskMpc202307.getSectionCount(waterList));

        waterList = new int[]{7523, 13005, 13004, 13003, 13002, 13001, 2611, 11750, 7807, 4943, 14631, 13265, 14040, 13655, 5777, 1588, 7818, 10266, 6164, 7832, 13131, 19289, 11243, 14712, 17721, 18687, 13889, 13888, 13887, 13886, 4703, 13094, 3933, 3932, 3931, 3930, 3929, 3928, 3182, 19377, 13405, 13886, 9842, 975, 16071};
        System.out.println("检查3:" + qskMpc202307.getSectionCount(waterList));

    }
}
