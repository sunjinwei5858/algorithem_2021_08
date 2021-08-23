package com.sunjinwei.tree;

/**
 * 树的最小深度 力扣111
 * 这道题⽬要是稍不留⼼很容易犯错。注意这⾥最⼩深度是从根节点到最近叶⼦节点的最短路径上的节点数量。注意是叶⼦节点。
 * 求⼆叉树的最小深度和求二叉树的最⼤深度的差别主要在于处理左右孩子不为空的逻辑。
 */
public class TreedMinDepth {

    /**
     * 后序遍历
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right == null) {
            return minDepth(root.left) + 1;
        }
        if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        }
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        return Math.min(l, r) + 1;
    }
}
