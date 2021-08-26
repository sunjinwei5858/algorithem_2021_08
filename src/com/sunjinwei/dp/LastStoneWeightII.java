package com.sunjinwei.dp;

/**
 * 1049. 最后一块石头的重量 II
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * ps:
 * 1.核心在于如何思考将这个问题转化为背包问题？
 * 2.所有石头拆成两堆，并且这两堆石头的重量要尽可能一样，这样才能保证最后返回的是最小的可能重量
 * 3.根据第二点，可以抽象为背包问题，dp[j]表示背包重量为j 可以获取的最大重量，
 * 4.最后的结果集就是用sum-dp[sum/2]-dp[sum/2]
 * 5.这种一分为二的思想 其实和分割等和子集差不多
 */
public class LastStoneWeightII {

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        int target = sum / 2;
        // 状态定义：dp[i][j] 表示 有i个石头 背包重量为j，可以获取的最大重量
        int[][] dp = new int[stones.length][target + 1];
        // 初始化dp[i][0] 无需初始化
        // 初始化dp[0][j]
        for (int j = 0; j <= target; j++) {
            if (stones[0] <= j) {
                dp[0][j] = stones[0];
            }
        }
        // bug i从1开始
        for (int i = 1; i < stones.length; i++) {
            for (int j = 0; j <= target; j++) {
                // bug 是大于j
                if (stones[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], stones[i] + dp[i - 1][j - stones[i]]);
                }
            }
        }
        int t = dp[stones.length - 1][target];
        return sum - 2 * t;
    }

}
