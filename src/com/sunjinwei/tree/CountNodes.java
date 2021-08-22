package com.sunjinwei.tree;


/**
 * 统计完全二叉树的节点 【222】
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 完全二叉树 的定义如下：
 * 在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1-2~h 个节点。
 */
public class CountNodes {

    /**
     * 完全二叉树的节点个数就是普通二叉树和满二叉树的结合版
     * 利用满二叉树是特殊的完全二叉树，如果满二叉树的层数为h，则总节点数为：2^h - 1
     * 前序遍历
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 判断是不是满二叉树 也就是判断左右子树的高度是不是相同
        int leftTreeHeight = getLeftTreeHeight(root);
        int rightTreeHeight = getRightTreeHeight(root);
        if (leftTreeHeight == rightTreeHeight) {
            // 如果满二叉树的层数为h，则总节点数为：2^h - 1
            return (int) Math.pow(2, leftTreeHeight) - 1;
        }
        // 否则正常走普通树的后序遍历
        leftTreeHeight = countNodes(root.left);
        rightTreeHeight = countNodes(root.right);
        return leftTreeHeight + rightTreeHeight + 1;
    }

    private int getLeftTreeHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            node = node.left;
            height++;
        }
        return height;
    }

    private int getRightTreeHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            node = node.right;
            height++;
        }
        return height;
    }
}
