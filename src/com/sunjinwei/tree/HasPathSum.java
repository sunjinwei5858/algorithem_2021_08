package com.sunjinwei.tree;

/**
 * 路径总和，举一反三：回溯算法中的组合总和 【力扣112】
 * 给定⼀个⼆叉树和⼀个⽬标和，判断该树中是否存在根节点到叶⼦节点的路径，这条路径上所有节点值相加等于⽬
 * 标和。
 * 注意：一定是根节点到叶子节点
 * ps：这里不需要遍历二叉树所有节点 所以递归函数需要有返回值
 */
public class HasPathSum {

    /**
     * 方法1：在root的时候就减去
     * 只需要遍历单边 递归函数需要返回值，如果是遍历整颗树 可以没有返回值
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        // 在这里就进行减去root的val
        return process(root, targetSum - root.val);
    }

    private boolean process(TreeNode root, int targetSum) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null && targetSum == 0) {
            return true;
        }
        if (left != null) {
            boolean l = process(root.left, targetSum - left.val);
            if (l) {
                return true;
            }
        }
        if (right != null) {
            boolean r = process(root.right, targetSum - right.val);
            if (r) {
                return true;
            }
        }
        return false;
    }

    /**
     * 方法2：
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return process2(root, targetSum);
    }

    private boolean process2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 其实这里使用了回溯 target-root.val
        if (left == null && right == null && targetSum == root.val) {
            return true;
        }
        // 其实这里使用回溯
        return process2(left, targetSum - root.val) || process2(right, targetSum - root.val);
    }

    public static void main(String[] args) {
        HasPathSum hasPathSum = new HasPathSum();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        int targetSum = 1;
        boolean b = hasPathSum.hasPathSum2(root, targetSum);
        System.out.println(b);
    }
}
