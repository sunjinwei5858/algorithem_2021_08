package com.sunjinwei.dp;

/**
 * 96 不同的二叉搜索树
 * ps：思路和整数拆分一样，自己构造斐波那契数列，在长度为i 在j位置进行拆分，然后让j走一圈 找出最大值
 * 唯一不同的是边界问题 这里j可以取到i
 */
public class NumBSTTrees {

    public int numTrees(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            // !!!! 这里j可以取到i
            for (int j = 1; j <= i; j++) {
                sum += dp[j - 1] * dp[i - j];
            }
            dp[i] = sum;
        }
        return dp[n];
    }
}
