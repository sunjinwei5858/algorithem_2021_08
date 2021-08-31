package com.sunjinwei.double_point;

/**
 * 接雨水 42 字节面试题
 * ps：
 * 1.按照一列一列来取，左边找最大高度 右边找最大高度 这两者取最小 然后减去当前元素i的高度
 * 2.这里的获取左边最大高度 和右边高度是针对nums[i] 对于当前i位置的，所以需要每次更新
 */
public class JieYuShui {

    /**
     * 暴力法
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            // 每次都必须重置为0
            int leftMax = 0;
            int rightMax = 0;
            // 取左边的最大值
            for (int j = i; j >= 0; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            // 取右边的最大值
            for (int j = i; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            res += Math.min(leftMax, rightMax) - height[i];
        }
        return res;
    }

    public int trap2(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        // 从左往右 计算左边最大值
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        // 从右往左 计算右边最大值
        rightMax[n - 1] = height[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }


}
