package com.sunjinwei.dp;

/**
 * 剑指 Offer II 101. 分割等和子串
 * 416 分割等和子集
 * 给定一个非空的正整数数组 nums ，请判断能否将这些数字分成元素和相等的两部分。
 * ps：
 * 1.转化为01背包问题，因为每个元素只能被选择一次
 * 2.鲁棒性：1如果是奇数 2如果元素的最大值都大于sum的一半
 */
public class CanPartition {

    /**
     * 01背包问题: 二维数组
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        // 1先判断nums的sum是不是偶数 如果是奇数直接return 不能被分割等和子集
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        // 鲁棒性1
        if (sum % 2 == 1) {
            return false;
        }
        // 取一半
        sum = sum / 2;
        // 鲁棒性2
        if (max > sum) {
            return false;
        }
        // 转化为01背包
        // dp[i][j]: 取元素i 放到背包容量为j的最大和
        int[][] dp = new int[nums.length][sum + 1];
        // 初始化
        // dp[i][0]: 无需处理
        // dp[0][j]: 需要初始化
        for (int j = 0; j <= sum; j++) {
            if (nums[0] <= j) {
                dp[0][j] = nums[0];
            }
        }
        // 遍历：先遍历物品 然后背包重量
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                }
            }
        }
        if (dp[nums.length - 1][sum] == sum) {
            return true;
        }
        return false;
    }


    /**
     * 01背包问题: 一维数组
     * 注意点：可以发现在计算 dp 的过程中，每一行的 dp 值都只与上一行的 dp 值有关
     * 且需要注意的是第二层的循环我们需要从大到小计算，
     * 因为如果我们从小到大更新 dp 值，那么在计算dp[j] 值的时候，dp[j−nums[i]] 已经是被更新过的状态，
     * 不再是上一行的dp 值。
     * 因为上一行也就是外层循环i的循环，内层循环是j的循环，如果j从小到大 那么dp[j-nums[i]]会不断更新
     * 1.j一定要倒叙
     * 2.无需初始化
     *
     * @param nums
     * @return
     */
    public boolean canPartition2(int[] nums) {
        // 1先判断nums的sum是不是偶数 如果是奇数直接return 不能被分割等和子集
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        if (sum % 2 == 1) {
            return false;
        }
        // 取一半
        sum = sum / 2;
        if (max > sum) {
            return false;
        }
        // 转化为01背包
        // dp[i][j]: 取元素i 放到背包容量为j的最大和
        int[] dp = new int[sum + 1];
        // 初始化
        // dp[j]: 无需处理
        // 遍历：先遍历物品 然后背包重量
        for (int i = 1; i < nums.length; i++) {
            // !!!!! 状态压缩之后 这里一定变成倒叙 不然会重复使用
            for (int j = sum; j > 0; j--) {
                if (j < nums[i]) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
            }
        }
        if (dp[sum] == sum) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CanPartition canPartition = new CanPartition();
        int[] arr = {1, 2, 5};
        boolean b = canPartition.canPartition(arr);
        System.out.println(b);
    }
}
