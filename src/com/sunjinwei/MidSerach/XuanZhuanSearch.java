package com.sunjinwei.MidSerach;

/**
 * 33. 搜索旋转排序数组
 */
public class XuanZhuanSearch {
    public int search(int[] nums, int target) {
        // 鲁棒性
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 特殊情况
        int n = nums.length;
        // 二分查找
        int l = 0;
        int r = n - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            // 左半部分有序
            if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid]) {
                    // 说明更靠近l位置 向左移动 收缩右边界
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // 右半部分有序
                if (target > nums[mid] && target <= nums[r]) {
                    // 说明更靠近r位置 向右移动 缩小左边界
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
