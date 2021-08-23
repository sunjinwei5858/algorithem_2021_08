package com.sunjinwei.tree;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113 路径总和  返回所有的路径
 * ps: 这里要遍历二叉树所有路径 所以递归函数可以不需要返回值
 */
public class PathSum {

    public List<List<Integer>> res = new ArrayList<>();

    /**
     * 简洁的回溯写法：不提前将root的val添加到path
     *
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        process(root, targetSum, new LinkedList<>());
        return res;
    }

    private void process(TreeNode root, int targetSum, LinkedList<Integer> path) {
        if (root == null) {
            return;
        }
        // 回溯1
        if (root.left == null && root.right == null && targetSum == root.val) {
            path.add(root.val);
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        // 回溯2
        path.add(root.val);
        process(root.left, targetSum - root.val, path);
        process(root.right, targetSum - root.val, path);
        path.removeLast();
    }

    /**
     * 细节的回溯写法: 提前将root的val添加到path
     *
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        LinkedList<Integer> path = new LinkedList<>();
        path.add(root.val);
        process2(root, targetSum, new LinkedList<>());
        return res;
    }

    private void process2(TreeNode root, int targetSum, LinkedList<Integer> path) {
        if (root.left == null && root.right == null && targetSum == root.val) {
            res.add(path);
        }
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left != null) {
            path.add(root.left.val);
            process2(root.left, targetSum - root.val, path);
            path.removeLast();
        }
        if (root.right != null) {
            path.add(root.right.val);
            process2(root.right, targetSum - root.val, path);
            path.removeLast();
        }
    }

}
