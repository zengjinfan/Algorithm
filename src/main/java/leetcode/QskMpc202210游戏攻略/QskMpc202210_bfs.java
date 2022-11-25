package leetcode.QskMpc202210游戏攻略;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class QskMpc202210_bfs {

    //用于存放已经处理过的结果
    List<Set<Integer>> res = new ArrayList<>();

    public List<List<Integer>> getPreTasks(int n, int[][] taskDependList) {
        //存放每个节点的直接前置任务
        List<Integer>[] nodePreList = new List[n];
        for (int i = 0; i < n; i++) nodePreList[i] = new ArrayList<>();
        for (int[] edge : taskDependList) {
            nodePreList[edge[1]].add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            res.add(new HashSet<>());
        }
        //BFS获取所有任务的前置任务
        for (int i = 0; i < n; i++) {
            bfs(i, nodePreList);
        }
        List<List<Integer>> finalRes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> finalCur = new ArrayList<>(res.get(i));
            Collections.sort(finalCur);
            finalRes.add(finalCur);
        }
        return finalRes;
    }

    private void bfs(int index, List<Integer>[] nodePreList) {
        boolean[] isVisited = new boolean[nodePreList.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        isVisited[index] = true;
        // 0 <- 1 <- 2 <- 3 <- 5 <- 6
        //             <- 4
        while (queue.size() > 0) {
            int cur = queue.poll();
            for (int pre : nodePreList[cur]) {
                if (!isVisited[pre]) {
                    res.get(index).add(pre);
                    isVisited[pre] = true;
                    queue.add(pre);
                } else {
                    System.out.println(pre + " 已被访问过 " + index);
                }
            }
        }
    }

    public static void main(String[] args) {
////        示例1：
////        输入：n=5, taskDependList={{0,1},{0,2},{1,3},{2,3}}
////        输出：{{},{0},{0},{0,1,2},{}}
//
        int[][] taskDependList = new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        System.out.println(new QskMpc202210_bfs().getPreTasks(5, taskDependList));
//
////        示例2：
////        输入：n=6, taskDependList={{0,1},{1,3},{2,4},{3,5},{4,5}}
////        输出：{{},{0},{},{0,1},{2},{0,1,2,3,4}}
//        taskDependList = new int[][]{{0, 1}, {1, 3}, {2, 4}, {3, 5}, {4, 5}};
//        qskMpc202210 = new QskMpc202210_1();
//        System.out.println(qskMpc202210.getPreTasks(6, taskDependList));
//
////        示例3：
////        输入：n=8, taskDependList={{0,3},{1,3},{1,4},{2,4},{3,5},{3,6},{4,6},{2,7}}
////        输出：{{},{},{},{0,1},{1,2},{0,1,3},{0,1,2,3,4},{2}}
//        taskDependList = new int[][]{{0, 3}, {1, 3}, {1, 4}, {2, 4}, {3, 5}, {3, 6}, {4, 6}, {2, 7}};
//        qskMpc202210 = new QskMpc202210_1();
//        System.out.println(qskMpc202210.getPreTasks(8, taskDependList));
//
////        检查1：
////        输入：n=9, taskDependList={{0,1},{1,3},{1,4},{2,4},{3,5},{3,6},{3,4},{4,6},{2,7},{6,7},{5,8}}
//        taskDependList = new int[][]{{0, 1}, {1, 3}, {1, 4}, {2, 4}, {3, 5}, {3, 6}, {3, 4}, {4, 6}, {2, 7}, {6, 7}, {5, 8}};
//        qskMpc202210 = new QskMpc202210_1();
//        System.out.println(qskMpc202210.getPreTasks(9, taskDependList));
//
////        检查2：
////        输入：n=10, taskDependList={{0,2},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6},{4,8},{5,9},{3,9}}
//        taskDependList = new int[][]{{0, 2}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}, {4, 8}, {5, 9}, {3, 9}};
//        qskMpc202210 = new QskMpc202210_1();
//        System.out.println(qskMpc202210.getPreTasks(10, taskDependList));
//
////        检查3：
////        输入：n=12, taskDependList={{1,0},{5,2},{7,3},{2,4},{4,8},{2,9},{9,4},{9,11},{11,10},{8,10},{0,11}}
//        taskDependList = new int[][]{{1, 0}, {5, 2}, {7, 3}, {2, 4}, {4, 8}, {2, 9}, {9, 4}, {9, 11}, {11, 10}, {8, 10}, {0, 11}};
//        qskMpc202210 = new QskMpc202210_1();
//        System.out.println(qskMpc202210.getPreTasks(12, taskDependList));

        System.out.println(new QskMpc202210_bfs().getPreTasks(7, new int[][]{{1, 0}, {2, 1}, {3, 2}, {4, 2}, {5, 3}, {5, 4}, {6, 5}}));
    }
}
