package com.sunjinwei.mid_serach;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * ps:
 * 1.题目的要求是找到左边界和右边界
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        int l = 0;
        int r = nums.length - 1;
        // 1找左边界，需要不断收缩右侧边界
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] == target) {
                // 因为是找左边界 所以继续收缩右侧边界 搜索区间变为[left, mid-1]
                r = mid - 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为[left, mid-1]
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // 终止条件
        if (l >= nums.length || nums[l] != target) {
            return res;
        }
        // 找到左侧边界
        res[0] = l;
        // 2找右边界，需要不断收缩左侧边界
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] == target) {
                // 收缩左边界 [mid+1， r]
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // 终止条件
        if (r < 0 || nums[r] != target) {
            return res;
        }
        res[1] = r;
        return res;
    }
}
