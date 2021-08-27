package com.sunjinwei.MidSerach;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法
 * ps: 这道题 其实就是搜索左边界 如果存在 返回 ；如果不存在 进行+1
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] == target) {
                // 收缩右边界
                r = mid - 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
