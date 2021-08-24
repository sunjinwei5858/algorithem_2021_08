package com.sunjinwei.tree;

/**
 * 经典题目
 * 二叉树的镜像
 * 翻转二叉树 力扣226
 */
public class MirrorTree {

    /**
     * 后序遍历
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 前序遍历
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree2(root.left);
        mirrorTree2(root.right);
        return root;
    }

}
