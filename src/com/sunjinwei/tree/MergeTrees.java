package com.sunjinwei.tree;

import java.util.LinkedList;

/**
 * 合并两个二叉树 力扣617
 * ps：同时遍历两棵树，构造一个新树 还是在原来树上操作
 * 类似题型：对称二叉树也就是二叉树的镜像
 * 递归和迭代法
 * ps：迭代法 不是层序遍历 而是使用队列解决
 */
public class MergeTrees {

    /**
     * 递归法: 在原来树上操作
     *
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    /**
     * 迭代法：在原来树上操作
     */
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            node1.val += node2.val;
            if (node1.left != null && node2.left != null) {
                queue.offer(node1.left);
                queue.offer(node2.left);
            }
            if (node1.right != null && node2.right != null) {
                queue.offer(node1.right);
                queue.offer(node2.right);
            }
            // !!!! 因为我们是在原来树上操作
            if (node1.left == null && node2.left != null) {
                node1.left = node2.left;
            }
            if (node1.right == null && node2.right != null) {
                node1.right = node2.right;
            }
        }
        return root1;
    }
}
