package leetcode.QskMpc202210游戏攻略;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class QskMpc202210 {

    public List<List<Integer>> getPreTasks(int n, int[][] taskDependList) {
        Map<Integer, Set<Integer>> taskDependMap = new HashMap<>();
        for (int i = 0; i < taskDependList.length; i++) {
            int[] taskArray = taskDependList[i];
            taskDependMap.computeIfAbsent(taskArray[1], k -> new HashSet<>()).add(taskArray[0]);
        }
        List<List<Integer>> orderTaskDependMap = new ArrayList<>();
        for(int i = 0; i < n; i ++) {
            Set<Integer> parenDependTasks = findParenDependTasks(i, taskDependMap);
            if (parenDependTasks.size() > 0) {
                List<Integer> list = parenDependTasks.stream().sorted().collect(Collectors.toList());
                orderTaskDependMap.add(list);
            } else {
                orderTaskDependMap.add(Collections.emptyList());
            }
        }
        return orderTaskDependMap;
    }

    private Set<Integer> findParenDependTasks(int i, Map<Integer, Set<Integer>> taskDependMap){
        Set<Integer> totalDependSet = new HashSet<>();
        Set<Integer> dependSet = taskDependMap.get(i);
        if(dependSet != null && dependSet.size() > 0){
            totalDependSet.addAll(dependSet);
            for (Integer depend : dependSet) {
                totalDependSet.addAll(findParenDependTasks(depend, taskDependMap));
            }
        }
        return totalDependSet;
    }

    public static void main(String[] args) {
//        示例1：
//        输入：n=5, taskDependList={{0,1},{0,2},{1,3},{2,3}}
//        输出：{{},{0},{0},{0,1,2},{}}

        int[][] taskDependList = new int[][]{{0,1},{0,2},{1,3},{2,3}};
        QskMpc202210 qskMpc202210 = new QskMpc202210();
        System.out.println(qskMpc202210.getPreTasks(5, taskDependList));

//        示例2：
//        输入：n=6, taskDependList={{0,1},{1,3},{2,4},{3,5},{4,5}}
//        输出：{{},{0},{},{0,1},{2},{0,1,2,3,4}}
        taskDependList = new int[][]{{0,1},{1,3},{2,4},{3,5},{4,5}};
        qskMpc202210 = new QskMpc202210();
        System.out.println(qskMpc202210.getPreTasks(6, taskDependList));

//        示例3：
//        输入：n=8, taskDependList={{0,3},{1,3},{1,4},{2,4},{3,5},{3,6},{4,6},{2,7}}
//        输出：{{},{},{},{0,1},{1,2},{0,1,3},{0,1,2,3,4},{2}}
        taskDependList = new int[][]{{0,3},{1,3},{1,4},{2,4},{3,5},{3,6},{4,6},{2,7}};
        qskMpc202210 = new QskMpc202210();
        System.out.println(qskMpc202210.getPreTasks(8, taskDependList));

//        检查1：
//        输入：n=9, taskDependList={{0,1},{1,3},{1,4},{2,4},{3,5},{3,6},{3,4},{4,6},{2,7},{6,7},{5,8}}
        taskDependList = new int[][]{{0,1},{1,3},{1,4},{2,4},{3,5},{3,6},{3,4},{4,6},{2,7},{6,7},{5,8}};
        qskMpc202210 = new QskMpc202210();
        System.out.println(qskMpc202210.getPreTasks(9, taskDependList));

//        检查2：
//        输入：n=10, taskDependList={{0,2},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6},{4,8},{5,9},{3,9}}
        taskDependList = new int[][]{{0,2},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6},{4,8},{5,9},{3,9}};
        qskMpc202210 = new QskMpc202210();
        System.out.println(qskMpc202210.getPreTasks(10, taskDependList));

//        检查3：
//        输入：n=12, taskDependList={{1,0},{5,2},{7,3},{2,4},{4,8},{2,9},{9,4},{9,11},{11,10},{8,10},{0,11}}
        taskDependList = new int[][]{{1,0},{5,2},{7,3},{2,4},{4,8},{2,9},{9,4},{9,11},{11,10},{8,10},{0,11}};
        qskMpc202210 = new QskMpc202210();
        System.out.println(qskMpc202210.getPreTasks(12, taskDependList));
    }
}
