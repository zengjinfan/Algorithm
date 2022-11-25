package leetcode.QskMpc202211最强闯关;

class QskMpc202211 {
    public int maxStage(int[] stage, int attackPoints, int winCardCount) {
        //初始攻击值
        int currentAttachNum = stage[0];

        int res = maxStage(stage, 1, currentAttachNum, attackPoints, winCardCount);
        return res;
    }

    /**
     * 在第i关可以通过的最大关数
     *
     * @param stage
     * @param i                当前关卡 1 ~ n-1
     * @param currentAttachNum 当前攻击值
     * @param attackPoints     当前剩余点数
     * @param winCardCount     剩余
     * @return
     */
    private int maxStage(int[] stage, int i, int currentAttachNum, int attackPoints, int winCardCount) {
        if (i == stage.length) {
            return 0;
        }
        if (currentAttachNum > stage[i]) {
            return 1 + maxStage(stage, i + 1, stage[i], attackPoints, winCardCount);
        } else {
            //当前攻击力不够的情况，分两种情况：
            if (currentAttachNum + attackPoints < stage[i]) {
                //情况1：加上攻击点数都不够boss的攻击值
                if (winCardCount > 0) {
                    //有剩余必胜卡则使用一张必胜卡
                    return 1 + maxStage(stage, i + 1, stage[i], attackPoints, winCardCount - 1);
                } else {
                    //没有必胜卡则游戏结束
                    return 0;
                }
            } else {
                //情况2：加上点数够boss的攻击值
                if (winCardCount == 0) {
                    //没有必胜卡，则只能使用攻击点数
                    //6 = 10 - (12 - 8)
                    attackPoints = attackPoints - (stage[i] - currentAttachNum);
                    return 1 + maxStage(stage, i + 1, stage[i], attackPoints, winCardCount);
                } else {
                    //有必胜卡，攻击点数也够，用哪个更优？
                    //两条路可以走，一种是用必胜卡，一种是用攻击点数，两者取其更优者
                    //使用必胜卡
                    int choose1 = 1 + maxStage(stage, i + 1, stage[i], attackPoints, winCardCount - 1);
                    //使用点数
                    attackPoints = attackPoints - (stage[i] - currentAttachNum);
                    int choose2 = 1 + maxStage(stage, i + 1, stage[i], attackPoints, winCardCount);
                    return Math.max(choose1, choose2);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] stage0 = {6};
        int attackPoints0 = 0;
        int winCardCount0 = 0;
        int res = new QskMpc202211().maxStage(stage0, attackPoints0, winCardCount0);
        System.out.println("特殊：" + res);

        int[] stage = {5, 3, 7, 19, 22, 24};
        int attackPoints = 5;
        int winCardCount = 1;
        res = new QskMpc202211().maxStage(stage, attackPoints, winCardCount);
        System.out.println("示例1：" + res);

        int[] stage2 = {14, 3, 19, 18, 25, 28};
        int attackPoints2 = 25;
        int winCardCount2 = 0;
        res = new QskMpc202211().maxStage(stage2, attackPoints2, winCardCount2);
        System.out.println("示例2：" + res);

        int[] stage3 = {1, 13, 1, 1, 13, 5, 11, 11, 13, 1, 19};
        int attackPoints3 = 6;
        int winCardCount3 = 2;
        res = new QskMpc202211().maxStage(stage3, attackPoints3, winCardCount3);
        System.out.println("示例3：" + res);


        int[] stage4 = {213, 59, 76, 87, 209, 98, 94, 175, 249, 123, 109, 233, 199, 162, 51, 92, 146, 154, 146, 118, 183};
        int attackPoints4 = 200;
        int winCardCount4 = 3;
        res = new QskMpc202211().maxStage(stage4, attackPoints4, winCardCount4);
        System.out.println("检查1：" + res);

        int[] stage5 = {232, 161, 89, 177, 117, 212, 126, 247, 155, 197, 88, 217, 81, 207, 228, 239, 144, 155};
        int attackPoints5 = 120;
        int winCardCount5 = 4;
        res = new QskMpc202211().maxStage(stage5, attackPoints5, winCardCount5);
        System.out.println("检查2：" + res);

        int[] stage6 = {4663, 3020, 7789, 1627, 9668, 1356, 4207, 1133, 8765, 4649, 205, 6455, 8864, 3554, 3916, 5925, 3995, 4540, 3487, 5444, 8259, 8802, 6777, 7306, 989, 4958, 2921, 8155, 4922, 2469, 6923, 776, 9777, 1796, 708, 786, 3158, 7369, 8715, 2136, 2510, 3739, 6411, 7996, 6211, 8282, 4805, 236, 1489, 7698};
        int attackPoints6 = 3500;
        int winCardCount6 = 7;
        res = new QskMpc202211().maxStage(stage6, attackPoints6, winCardCount6);
        System.out.println("检查3：" + res);

    }

}
