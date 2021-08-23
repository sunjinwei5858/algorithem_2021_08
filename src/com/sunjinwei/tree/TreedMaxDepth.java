package com.sunjinwei.tree;

/**
 * 树的最大深度
 */
public class TreedMaxDepth {

    /**
     * 直接后序遍历
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l, r) + 1;
    }
}
