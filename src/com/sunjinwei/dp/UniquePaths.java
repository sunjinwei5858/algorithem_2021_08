package com.sunjinwei.dp;

/**
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 */
public class UniquePaths {

    /**
     * 二维数组
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        // 1dp[i][j]: 表示走到第i行第j列的路径
        int[][] dp = new int[m][n];
        // 2初始化数据
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 3状态方程
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 一维数组：发现dp[i][j]只和j-1和j列有关系，
     * 因此我们可以使用滚动数组代替代码中的二维数组，使空间复杂度降低为 O(n)
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        // 1dp[i][j]: 表示走到第i行第j列的路径
        int[] dp = new int[n];
        // 2初始化数据
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 3状态方程
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
