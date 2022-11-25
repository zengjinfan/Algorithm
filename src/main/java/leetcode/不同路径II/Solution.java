package leetcode.不同路径II;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        boolean hasObstacle = false;
        for (int i = 0; i < m; i++) {
            //检查是否有障碍物
            if (!hasObstacle) {
                if (obstacleGrid[i][0] == 1) {
                    hasObstacle = true;
                }
            }
            if (hasObstacle) {
                //第一列，从有障碍物开始，路径数目都是0
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }
        hasObstacle = false;
        for (int j = 0; j < n; j++) {
            //检查是否有障碍物
            if (!hasObstacle) {
                if (obstacleGrid[0][j] == 1) {
                    hasObstacle = true;
                }
            }
            if (hasObstacle) {
                //第一行，从有障碍物开始，路径数目都是0
                dp[0][j] = 0;
            } else {
                dp[0][j] = 1;
            }
        }
        int choose1 = 0;
        int choose2 = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        choose1 = 0;
                        if (obstacleGrid[i - 1][j] == 0) {
                            choose1 = dp[i - 1][j];
                        }
                        choose2 = 0;
                        if (obstacleGrid[i][j - 1] == 0) {
                            choose2 = dp[i][j - 1];
                        }
                        dp[i][j] = choose1 + choose2;
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] nums = {{0, 0, 1}, {0, 1, 0}, {1, 0, 0}};
        Solution solution = new Solution();
        System.out.println(solution.uniquePathsWithObstacles(nums));
    }
}
