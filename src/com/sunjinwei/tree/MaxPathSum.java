package com.sunjinwei.tree;

/**
 * 124 二叉树中的最大路径和
 * <p>
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * ps:
 * 1.使用全局变量进行维护
 * 2.递归函数不需要返回值
 * 3.如何求路径和 找最大路径和
 * 路径和：要么root 要么root+left 要么root+right 这三者取最大
 * 最大路径和：属于局部 也就是子树中 内部逻辑
 */
public class MaxPathSum {

    public int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        process(root);
        return res;
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    private int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = process(root.left);
        int r = process(root.right);
        l = Math.max(l, 0);
        r = Math.max(r, 0);
        // 获取局部最大和!!!!
        res = Math.max(l + r + root.val, res);
        // 对于root节点 只能取一边 root+left或者root+right 因为这里是返回给root的父节点
        return root.val + Math.max(l, r);
    }
}
