package com.sunjinwei.dp;

import java.util.Arrays;

/**
 * 完全平方数
 * ps：
 * 1.转化为完全背包，这道题其实就是零钱兑换I那道题 思路一模一样
 */
public class NumSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        // 初始化数据1，要给最大值
        Arrays.fill(dp, Integer.MAX_VALUE);
        // 初始化数据2：j=0 时 不能少
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) { // 物品
            int x = i * i;
            for (int j = x; j <= n; j++) { // 背包
                if (j - x >= 0) {
                    dp[j] = Math.min(dp[j], dp[j - x] + 1);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumSquares numSquares = new NumSquares();
        int i = numSquares.numSquares(12);
        System.out.println(i);
    }
}
