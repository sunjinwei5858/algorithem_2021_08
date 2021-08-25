package com.sunjinwei.dp;

/**
 * 63. 不同路径 II【有陷阱!!!!】
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 */
public class UniquePathsWithObstacles {

    /**
     * 1.二维数组如何求长度？
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        // 获取行数
        int m = obstacleGrid.length;
        // 获取列数
        int n = obstacleGrid[0].length;

        // 状态定义：m行n列
        int[][] dp = new int[m][n];
        // 初始化第一列数据
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            }else {
                // 陷阱!!!! 后面行不通了 只要出现了障碍物 障碍物后面的都为0
                break;
            }

        }
        // 初始化第一行数据
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
            }else {
                // 陷阱！！！！
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
