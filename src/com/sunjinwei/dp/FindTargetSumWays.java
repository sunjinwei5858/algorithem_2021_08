package com.sunjinwei.dp;

/**
 * 494 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * ps:
 * 1. 可以使用回溯
 * 2. 可以使用动态规划 转化为背包问题
 * 01背包问题是选或者不选，但本题是必须选，是选+还是选-。先将本问题转换为01背包问题。
 * 3.转化为动态规划 这道题比较难理解
 */
public class FindTargetSumWays {

    public Integer res = 0;

    /**
     * 方法1：回溯解决，抽象：二叉树的遍历
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        process(nums, target, 0);
        return res;
    }

    private void process(int[] nums, int target, int startIndex) {
        if (startIndex == nums.length) {
            if (target == 0) {
                res++;
            }
            return;
        }
        process(nums, target - nums[startIndex], startIndex + 1);
        process(nums, target + nums[startIndex], startIndex + 1);
    }

    /**
     * 方法2：背包问题，这道题和以前题目不同的是 可以为负数 所以初始化的时候要注意
     * https://leetcode-cn.com/problems/target-sum/solution/494-mu-biao-he-dong-tai-gui-hua-zhi-01be-78ll/
     * 找到nums一个正子集和一个负子集，使得总和等于target
     * sum(P) - sum(N) = target
     * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
     * 2 * sum(P) = target + sum(nums)
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays2(int[] nums, int target) {
        // 思路过程
        // 1加号的和为x，减号的和绝对值为y，那么x-y=target, x+y=sum, x = (target+sum)/2
        // 2根据上面的公式 就可以转化为背包问题 求等于x 有多少中解法 ，由最多能装多少 变为 有几种装法
        // 3还要注意特殊情况 sum要大于target x必须是整数 那么 （target+sum）必须是偶数

        // 极端情况
        if (nums.length == 1 && Math.abs(nums[0]) != Math.abs(target)) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 鲁棒性
        if (sum < target) {
            return 0;
        }
        // 鲁棒性
        if ((sum + target) % 2 == 1) {
            return 0;
        }
        int t = (sum + target) / 2;
        int[] dp = new int[t + 1];
        // 非常关键的初始化
        // 填满容量为j的背包，有dp[j]种方法。因为填满容量为0的背包有且只有一种方法，所以dp[0] = 1
        dp[0] = 1;
        // 因为这里是求有多少中方案 所以i需要从0开始
        for (int i = 0; i < nums.length; i++) {
            for (int j = t; j >= nums[i]; j--) {
                // 当前填满容量为j的包的方法数 = 之前填满容量为j的包的方法数 + 之前填满容量为j - num的包的方法数
                //也就是当前数num的加入，可以把之前和为j - num的方法数加入进来。
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[target];
    }

}
