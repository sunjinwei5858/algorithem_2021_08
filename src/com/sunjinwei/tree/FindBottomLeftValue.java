package com.sunjinwei.tree;

import java.util.LinkedList;

/**
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 */
public class FindBottomLeftValue {

    /**
     * 层序遍历：用一个变量记录最左边的值即可
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        int l = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            l = queue.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return l;
    }

    /**
     * 递归法：前序遍历+利用最大深度!!!!!
     */
    public int res = 0;
    public int maxDepth = 0;

    public int findBottomLeftValue2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 最底层最左边的值就是目标值 也就是找最大深度最左边的值
        process(root, 1);
        return res;
    }

    private void process(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                res = root.val;
            }
        }
        process(root.left, depth + 1);
        process(root.right, depth + 1);
    }

    public static void main(String[] args) {
        FindBottomLeftValue bottomLeftValue = new FindBottomLeftValue();
        TreeNode root = new TreeNode(1);
        int res = bottomLeftValue.findBottomLeftValue2(root);
        System.out.println(res);
    }


}
