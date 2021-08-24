package com.sunjinwei.tree;

import java.util.LinkedList;

/**
 * 对称二叉树 力扣101
 * ps: 这道题其实和合并二叉树思想类似，都是处理两颗 对称二叉树需要转化成处理两棵树
 * 递归法
 * 迭代法：使用队列 其实不是层序遍历, 空节点也进入队列
 */
public class IsSymmetric {

    /**
     * 递归法
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root.left, root.right);
    }

    private boolean process(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left == null && right != null) {
            return false;
        }
        // 走到这里 说明left和right都不为空
        if (left.val != right.val) {
            return false;
        }
        // 继续比较两棵树的内测和外侧
        return process(left.left, right.right) && process(left.right, right.left);
    }

    /**
     * 迭代法
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode != null && rightNode == null) {
                return false;
            }
            if (leftNode == null && rightNode != null) {
                return false;
            }
            // 走到这里 说明left和right都不为空
            if (leftNode.val != rightNode.val) {
                return false;
            }
            // 继续比较后面的节点 内测和外侧
            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }
        return true;
    }
}
