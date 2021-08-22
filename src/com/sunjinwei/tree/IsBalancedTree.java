package com.sunjinwei.tree;

/**
 * 是否是平衡二叉树 【力扣110 难度简单】
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class IsBalancedTree {

    /**
     * 后序遍历处理
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root) != -1;
    }

    private int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = process(root.left);
        if (l == -1) {
            return -1;
        }
        int r = process(root.right);
        if (r == -1) {
            return -1;
        }
        int i = Math.abs(l - r);
        if (i > 1) {
            return -1;
        }
        return Math.max(l, r) + 1;
    }
}
