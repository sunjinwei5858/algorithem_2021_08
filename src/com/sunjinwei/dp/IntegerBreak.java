package com.sunjinwei.dp;

/**
 * 343 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * ps：自己构造斐波那契数列
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        // 状态方程：因为这里n可以取到 所以dp数组长度为n+1
        int[] dp = new int[n + 1];
        // 初始化
        dp[2] = 1;
        // 假设在j处进行拆分 那么 i-j可以继续拆分 也可以不拆分 ；根据这两种情况做动态规划
        // 因为j是从左往右移动的 所以其实dp[i]也是会变化的 这里要让dp[i]保证最大
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                // 那么从1遍历j，⽐较(i - j) * j和dp[i - j] * j 取最⼤的。
                int a = Math.max(j * (i - j), dp[i - j] * j);
                max = Math.max(max, a);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
