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
     * 方法1：提前减去root.val
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
        // 1 因为提前减去 所以这里是判断targetSum=0
        if (root.left == null && root.right == null && targetSum == 0) {
            return true;
        }
        // 2 处理左子树和右子树时 也要提前减去 但是需要判空
        // 因为终⽌条件是判断叶⼦节点，所以递归的过程中就不要让空节点进⼊递归了。
        if (root.left != null) {
            boolean l = process(root.left, targetSum - root.left.val);
            if (l) {
                return true;
            }
        }
        if (root.right != null) {
            return process(root.right, targetSum - root.right.val);
        }
        return false;
    }

    /**
     * 方法2：不提前减去root.val的值
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
