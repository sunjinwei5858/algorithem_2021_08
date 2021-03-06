package com.sunjinwei.dp;

import java.util.Arrays;

/**
 * 零钱兑换I【力扣322】
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 */
public class CoinExchange {

    /**
     * 一维
     * 1.初始化数据注意要初始化最大，但是不要忘了 dp[0]=0的初始化 无为而治
     * 2.这里是找最少的硬币个数 状态定义要注意
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        // 状态定义：dp[j] 凑成j枚最少需要的硬币个数
        int[] dp = new int[amount + 1];
        // 初始化数据1
        Arrays.fill(dp, amount + 1);
        // 初始化数据2
        dp[0] = 0;
        // 遍历顺序
        // 其实这属于组合 外层循环使用元素 内层循环背包
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                // 需要的硬币个数
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        if (dp[amount] == (amount + 1)) {
            return -1;
        }
        return dp[amount];
    }

    private int res = Integer.MAX_VALUE;

    /**
     * 递归
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {

        process(coins, amount, 0, 0);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    private void process(int[] coins, int amount, int start, int count) {
        if (amount == 0) {
            res = Math.min(res, count);
            return;
        }
        //!!! 这个终止条件不能少
        if (amount < 0) {
            return;
        }
        for (int i = start; i < coins.length; i++) {
            // 可以重复选取 所以继续传入i
            // count需要加1
            process(coins, amount - coins[i], i, count + 1);
        }
    }
}
