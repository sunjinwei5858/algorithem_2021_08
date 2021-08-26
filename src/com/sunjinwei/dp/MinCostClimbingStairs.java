package com.sunjinwei.dp;

/**
 * 746. 使用最小花费爬楼梯
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 * 例子：
 * 输入：cost = [10, 15, 20]
 * 输出：15
 * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 * ps:
 * 1.每次可以选择爬一个楼梯或者两个楼梯 这就是爬楼梯的变种
 * 2.题目意思是：每次到达指定的楼梯 都需要支付对应的cost[i]体力
 * 3.从例子看出 到达了最后一步不需要花费体力了
 */
public class MinCostClimbingStairs {

    /**
     * 第一种方法：初始化花费体力，最后就不需要花费体力
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        // 状态定义：dp[i]表示到达第i层花费最小的体力
        int[] dp = new int[cost.length];
        // 初始化：刚开始需要进行花费体力 最后就不需要花费体力
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 0; i < cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        // 到达了最后一步就不需要花费体力了，所以这里需要进行取最小值
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    /**
     * 第二种方法：初始化不花费体力 最后花费体力
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs2(int[] cost) {
        // 状态定义：dp[i]表示到达第i层花费最小的体力
        int[] dp = new int[cost.length + 1];
        // 初始化：刚开始不需要进行花费体力 最后需要花费体力
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 0; i <= cost.length; i++) {
            // 第⼀步是不花费体⼒，最后⼀步是花费体⼒的。
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        // 到达了最后一步就不需要花费体力了，所以这里需要进行取最小值
        return dp[cost.length - 1];
    }

    /**
     * 第三种方法：初始化不花费体力
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs3(int[] cost) {
        int size = cost.length;
        int[] dp = new int[size];
        dp[0] = 0;
        dp[1] = Math.min(cost[0], cost[1]);
        for (int i = 2; i < size; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i - 1]);
        }
        return dp[size - 1];
    }
}
