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
     * 方法1：使用LinkedList接收 到达了叶子节点再处理，也是属于提前处理
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }
        LinkedList<Integer> path = new LinkedList<>();
        path.add(root.val);
        backTrack(root, path);
        return res;
    }

    private void backTrack(TreeNode root, LinkedList<Integer> path) {
        if (root.left == null && root.right == null) {
            // 处理
            String s = "";
            for (int i = 0; i < path.size() - 1; i++) {
                s += path.get(i) + "->";
            }
            s += path.get(path.size() - 1);
            res.add(s);
            return;
        }
        if (root.left != null) {
            path.add(root.left.val);
            backTrack(root.left, path);
            path.removeLast();
        }
        if (root.right != null) {
            path.add(root.right.val);
            backTrack(root.right, path);
            path.removeLast();
        }
    }

    /**
     * 方法2：不提前添加 使用字符串
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        if (root == null) {
            return res;
        }
        backTrack2(root, "");
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

    /**
     * 方法3：提前添加 使用字符串
     */
    public List<String> binaryTreePaths3(TreeNode root) {
        if (root == null) {
            return res;
        }
        backTrack3(root, root.val + "");
        return res;
    }

    private void backTrack3(TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            res.add(path);
            return;
        }
        if (root.left != null) {
            backTrack3(root.left, path + "->" + root.left.val);
        }
        if (root.right != null) {
            backTrack3(root.right, path + "->" + root.right.val);
        }
    }
}
