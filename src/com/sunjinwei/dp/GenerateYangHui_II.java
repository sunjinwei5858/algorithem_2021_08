package com.sunjinwei.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II 【美团面试题】
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * ps: 这里需要注意边界的处理
 */
public class GenerateYangHui_II {

    // 比如rowIndex=3 按照题目的要求 其实是要获取也就是获取第四行
    public List<Integer> getRow(int rowIndex) {
        // 注意
        int[][] dp = new int[rowIndex + 1][rowIndex + 1];
        List<Integer> res = new ArrayList();
        // 注意
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                if (i == rowIndex) {
                    res.add(dp[i][j]);
                }
            }
        }
        return res;
    }
}
