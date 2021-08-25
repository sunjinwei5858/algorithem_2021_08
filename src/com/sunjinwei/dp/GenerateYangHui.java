package com.sunjinwei.dp;

import jdk.nashorn.internal.ir.LiteralNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 力扣118 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
public class GenerateYangHui {

    /**
     * 官方题解
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // 处理两端的值
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // 否则获取上一层的[i-1][j-1]和[i-1][j]
                    Integer a = res.get(i - 1).get(j - 1);
                    Integer b = res.get(i).get(j - 1);
                    row.add(a + b);
                }
            }
            res.add(row);
        }
        return res;
    }

    /**
     * 动态规划
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        // 状态方程：dp[i][j] 表示第i行第j列的值
        int[][] dp = new int[numRows][numRows];
        // i 表示第几行
        // j 表示第几列 j从左到右 j的最大值就是i行 j<=i
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // 处理两端的值!!!!!
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    // 否则获取上一层的[i-1][j-1]和[i-1][j]
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                row.add(dp[i][j]);
            }
            res.add(row);
        }
        return res;
    }


    public static void main(String[] args) {
        GenerateYangHui generateYangHui = new GenerateYangHui();
        List<List<Integer>> lists = generateYangHui.generate(5);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }


    }
}
