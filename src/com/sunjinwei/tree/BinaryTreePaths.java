package com.sunjinwei.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的所有路径 【力扣257】
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 回溯+前序
 */
public class BinaryTreePaths {

    private List<String> res = new ArrayList<>();

    /**
     * 因为是根节点到叶子节点 所以使用前序遍历
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }
        backTrack(root, new LinkedList<Integer>());
        return res;
    }

    private void backTrack(TreeNode root, LinkedList<Integer> path) {
        // 终止条件1
        if (root == null) {
            return;
        }
        // 根节点
        path.add(root.val);
        // 终止条件2：真正的处理逻辑
        if (root.left == null && root.right == null) {
            // 处理
            String s = "";
            for (int i = 0; i < path.size() - 1; i++) {
                s += path.get(i) + "->";
            }
            s += path.get(path.size() - 1);
            res.add(s);
            // 撤销选择
            path.removeLast();
            return;
        }
        backTrack(root.left, path);
        backTrack(root.right, path);
        // 撤销选择
        path.removeLast();
    }

    /**
     * 方法2：简洁处理
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        if (root == null) {
            return res;
        }
        backTrack2(root, new String());
        return res;
    }

    private void backTrack2(TreeNode root, String path) {
        if (root == null) {
            return;
        }
        path += root.val;
        // 到达了叶子节点
        if (root.left == null && root.right == null) {
            res.add(path);
            return;
        }
        backTrack2(root.left, path + "->");
        backTrack2(root.right, path + "->");
    }
}
