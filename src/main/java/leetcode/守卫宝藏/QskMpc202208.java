package leetcode.守卫宝藏;

import java.util.ArrayList;
import java.util.List;

public class QskMpc202208 {
    public int minGuards(String treasureStr) {
        int result = 0;
        int length = treasureStr.length();
        List<Integer> tPositionList = new ArrayList<Integer>();
        for(int i = 0; i < length; i++) {
            char tempChar = treasureStr.charAt(i);
            if (tempChar == 'T') {
                boolean legal = check(tPositionList, i, length);
                if (!legal) {
                    return -1;
                } else {
                    tPositionList.add(i);
                }
            }
        }
        int pSize = tPositionList.size();
        for (int i = 0; i < pSize; ) {
            int curP = tPositionList.get(i);
            if (i < pSize - 1) {
                int nextP = tPositionList.get(i + 1);
                if (nextP - curP == 1) {//两个T相连
                    result += 1;
                    i = i + 1;
                } else if (nextP - curP == 2) {//两个T间隔一个字符，调到下下个T
                    result += 1;
                    i = i + 2;
                } else {//两个T间隔超过一个字符
                    result += 1;
                    i = i + 1;
                }
            } else {
                result += 1;
                i = i + 1;
            }
        }
        return result;
    }

    private boolean check(List<Integer> tPostSet, int i, int totalLength) {
        int size = tPostSet.size();
        if (size > 0) {
            int lastPosition = tPostSet.get(size - 1);
            if (lastPosition == i - 1) {//如果前一个T的位置是在i的前面
                if (lastPosition == 0) {//如果前一个T的位置是0，说明开头是TT，无解
                    return false;
                } else {
                    if (i == totalLength - 1) { //说明结尾是TT，无解
                        return false;
                    }
                    if (size > 1) {
                        Integer lastLastPosition = tPostSet.get(size - 2);
                        //三个T的位置连续，无解
                        return lastLastPosition != lastPosition - 1;
                    }
                }
            }
        } else if(totalLength == 1){ //只有一个T也无解
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String treasureStr = "TBBTBT";
        QskMpc202208 qskMpc202208 = new QskMpc202208();
        int res = qskMpc202208.minGuards(treasureStr);
        System.out.println(treasureStr + " : " + res);

        treasureStr = "TBBTTTB";
        res = qskMpc202208.minGuards(treasureStr);
        System.out.println(treasureStr + " : " + res);

        treasureStr = "TBBTTBBBBBTTBTBBTTBTTBBT";
        res = qskMpc202208.minGuards(treasureStr);
        System.out.println(treasureStr + " : " + res);

        System.out.println("=================检查1=================");
        treasureStr = "BTTBTTBTTBTTBBTBTTBTTB";
        res = qskMpc202208.minGuards(treasureStr);
        System.out.println(treasureStr + " : " + res);

        System.out.println("=================检查2=================");
        treasureStr = "BBBTBBTBTBTBTBTBTBTTBBTBTBTBTBTTBB";
        res = qskMpc202208.minGuards(treasureStr);
        System.out.println(treasureStr + " : " + res);

        System.out.println("=================检查3=================");
        treasureStr = "BTTBTTBTTBTTBBTBTTBTTBBTBBTBTBTBTBTBTBTTBBBTTBBBTBTBTBTBTBBTBTBTBTBTBBTTBTTBTTBBTTBTTBTTBBTTBTTBTTB";
        res = qskMpc202208.minGuards(treasureStr);
        System.out.println(treasureStr + " : " + res);
    }

}
