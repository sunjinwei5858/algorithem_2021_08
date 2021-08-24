package com.sunjinwei.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 98 验证二叉搜索树
 * <p>
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * ps:
 * 这道题有两个陷阱
 * 1.不能单纯的比较左节点小于中间节点，右节点大于中间节点就完事了，因为我们要比较的是所有左树节点小于中间节点，所有右树大于中间节点
 * 2.最小节点可能是int的最小值
 */
public class IsValidBST {

    public List<Integer> arr = new ArrayList<>();

    /**
     * 方法1：使用集合存储二叉树节点元素 然后再判断，中序遍历
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        process(root);
        for (int i = 1; i < arr.size(); i++) {
            // !!! 注意这里可以等于
            if (arr.get(i - 1) >= arr.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void process(TreeNode root) {
        if (root == null) {
            return;
        }
        process(root.left);
        arr.add(root.val);
        process(root.right);
    }

    public TreeNode pre;

    /**
     * 方法2：记录上一个节点 中序遍历
     *
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左子树
        boolean l = isValidBST2(root.left);
        // 根节点
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        // 右子树
        boolean r = isValidBST2(root.right);
        return l && r;
    }

    /**
     * 方法3：使用min和max固定住边界，中序遍历和前序遍历 都可以
     */
    public boolean isValidBST3(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process3(root, null, null);
    }

    private boolean process3(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        // 左孩子
        boolean l = process3(root.left, min, root);
        // 根节点
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        // 右孩子
        boolean r = process3(root.right, root, max);
        return l && r;
    }

    /**
     * 中序遍历 迭代法
     *
     * @param root
     * @return
     */
    public boolean isValidBST4(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                // 逻辑处理
                if (pre != null && pre.val >= curr.val) {
                    return false;
                }
                // 更新pre
                pre = curr;
                curr = curr.right;
            }
        }
        return true;
    }
}
