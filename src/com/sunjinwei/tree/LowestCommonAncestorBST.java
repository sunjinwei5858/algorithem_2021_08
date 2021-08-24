package com.sunjinwei.tree;

/**
 * BST的最近公共祖先
 * ps: 充分利用有序
 */
public class LowestCommonAncestorBST {

    /**
     * cur节点是数值在[p, q]区间中则说明该节点cur就是最近公共祖先了。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }
        // 情况1
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // 情况2
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // 情况3
        return root;
    }
}
