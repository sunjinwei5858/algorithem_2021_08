package com.sunjinwei.tree;

/**
 * 构造最大的二叉树 力扣654
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 * ps：这道题其实是比通过前序+中序或者后序+中序恢复二叉树更简单一点，但是思想都是通过传入数组的下标来处理
 */
public class ConstructMaximumBinaryTree {

    /**
     * 构造二叉树的题目 都可以采用传入索引的方式进行递归，一般都是前序遍历处理
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return process(nums, 0, nums.length);
    }

    /**
     * 传入索引的方式进行递归
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private TreeNode process(int[] nums, int l, int r) {
        // 终止条件
        if (l >= r) {
            return null;
        }
        // 获取根节点:二叉树的根是数组 nums 中的最大元素。
        int maxIndex = getArrayMaxIndex(nums, l, r);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = process(nums, l, maxIndex);
        root.right = process(nums, maxIndex + 1, r);
        return root;
    }

    private int getArrayMaxIndex(int[] nums, int l, int r) {
        int res = l;
        for (int i = l + 1; i < r; i++) {
            if (nums[i] > nums[res]) {
                res = i;
            }
        }
        return res;
    }
}
