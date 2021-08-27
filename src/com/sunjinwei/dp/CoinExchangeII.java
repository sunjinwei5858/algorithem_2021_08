package com.sunjinwei.dp;

/**
 * 零钱兑换II
 */
public class CoinExchangeII {

    /**
     * 一维数组
     *
     * @param amount
     * @param coins
     * @return
     */
    public int changeII(int amount, int[] coins) {
        // 转换为完全背包
        // 状态定义：dp[j]表示有硬币凑成价值为j的组合有多少种
        int[] dp = new int[amount + 1];
        // 初始化
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public int res = 0;

    /**
     * 递归
     *
     * @param amount
     * @param coins
     * @return
     */
    public int changeII2(int amount, int[] coins) {
        process(coins, amount, 0);
        return res;
    }

    private void process(int[] coins, int amount, int start) {
        if (amount == 0) {
            res++;
            return;
        }
        // !!! 这个终止条件千万不能少
        if (amount < 0) {
            return;
        }
        for (int i = start; i < coins.length; i++) {
            process(coins, amount - coins[i], i);
        }
    }


}
