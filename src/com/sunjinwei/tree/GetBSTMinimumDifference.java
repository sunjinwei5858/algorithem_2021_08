package com.sunjinwei.tree;

import java.util.Stack;

/**
 * 530. 二叉搜索树的最小绝对差 难度：简单
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * ps: 联想到判断是否是bst这道题目，记录上一个节点来处理
 * 这道题其实是送分题
 */
public class GetBSTMinimumDifference {

    private TreeNode pre;

    private int result = Integer.MAX_VALUE;

    /**
     * 中序遍历 递归处理
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return result;
        }
        // 需要遍历所有树上的节点 所以递归函数不需要返回值
        process(root);
        return result;
    }

    private void process(TreeNode root) {
        if (root == null) {
            return;
        }
        process(root.left);
        if (pre != null) {
            // 更新result
            result = Math.min(result, Math.abs(root.val - pre.val));
        }
        pre = root;
        process(root.right);
    }

    /**
     * 中序遍历-迭代法处理
     *
     * @param root
     * @return
     */
    public int getMinimumDifference2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        TreeNode curr = root;
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                if (pre != null) {
                    res = Math.min(res, Math.abs(pre.val - curr.val));
                }
                pre = curr;
                curr = curr.right;
            }
        }
        return res;
    }

}
