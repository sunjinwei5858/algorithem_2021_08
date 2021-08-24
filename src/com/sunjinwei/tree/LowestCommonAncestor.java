package com.sunjinwei.tree;

/**
 * 二叉树的最近公共祖先 力扣236
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * ps：
 * 1.自己也可以是自己的祖先
 * 2.后序遍历
 */
public class LowestCommonAncestor {
    /**
     * 后序遍历递归
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case1
        if (root == null) {
            return null;
        }
        // base case2：可以是自己本身
        if (root == p || root == q) {
            return root;
        }
        // 左孩子
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 右孩子
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 根节点 逻辑处理
        if (left == null && right == null) {
            return null;
        }
        // 找到p和q的最近公共祖先
        if (left != null && right != null) {
            return root;
        }
        // 只有其中一个为null 那么返回不为null的
        return left != null ? left : right;

    }
}
