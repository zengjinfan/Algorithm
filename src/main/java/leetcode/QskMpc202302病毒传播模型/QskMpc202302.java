package leetcode.QskMpc202302病毒传播模型;

import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class QskMpc202302 {

    public int getCovidCount(int n, int m, int k){
        List<Man> infectedList = new ArrayList<>();
        Man man = new Man(m, k);
        infectedList.add(man);
        for (int d = 2; d <= n; d++) {
            List<Man> needAddList = new ArrayList<>();
            Iterator<Man> iterator = infectedList.iterator();
            while (iterator.hasNext()) {
                Man tempMan = iterator.next();
                tempMan.process();
                if(tempMan.isInfected){
                    needAddList.add(new Man(m, k));
                }
                if(tempMan.isRestoreHealth){
                    iterator.remove();
                }
            }
            infectedList.addAll(needAddList);
        }
        return infectedList.size();
    }

    @Data
    class Man {
        //剩余潜伏天数
        int leftIncubationDay;
        //是否具备传染性
        boolean isInfected;
        //是否已痊愈
        boolean isRestoreHealth;
        //剩余感染天数
        int leftInfectedDay;

        public Man(int m, int k){
            leftIncubationDay = m;
            isInfected = false;
            leftInfectedDay = k;
        }

        public void process() {
            //没有恢复的人，就可能会被感染
            if(!isRestoreHealth){
                //潜伏期结束，就开始具备传染性
                if (!isInfected && --leftIncubationDay == 0) {
                    isInfected = true;
                }
                //第k天后，就恢复健康
                if (--leftInfectedDay == 0) {
                    isInfected = false;
                    isRestoreHealth = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        QskMpc202302 qskMpc202302 = new QskMpc202302();
        System.out.println(qskMpc202302.getCovidCount(5, 2, 3));

        qskMpc202302 = new QskMpc202302();
        System.out.println(qskMpc202302.getCovidCount(4, 1, 3));

        qskMpc202302 = new QskMpc202302();
        System.out.println(qskMpc202302.getCovidCount(10, 3, 6));

        qskMpc202302 = new QskMpc202302();
        System.out.println("检查1");
        System.out.println(qskMpc202302.getCovidCount(15, 4, 8));

        qskMpc202302 = new QskMpc202302();
        System.out.println("检查2");
        System.out.println(qskMpc202302.getCovidCount(50, 2, 10));

        qskMpc202302 = new QskMpc202302();
        System.out.println("检查3");
        System.out.println(qskMpc202302.getCovidCount(888, 5, 2));

    }
}
