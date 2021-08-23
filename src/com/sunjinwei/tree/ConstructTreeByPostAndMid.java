package com.sunjinwei.tree;

import java.util.HashMap;

/**
 * 根据后序和中序构造二叉树 【力扣106】
 */
public class ConstructTreeByPostAndMid {

    public int[] midArr;
    public int[] postArr;
    public HashMap<Integer, Integer> hashMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        this.hashMap = new HashMap<>();
        this.midArr = inorder;
        this.postArr = postorder;
        for (int i = 0; i < midArr.length; i++) {
            hashMap.put(midArr[i], i);
        }
        return process(0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode process(int midLeft, int midRight, int postLeft, int postRight) {
        if (midLeft > midRight || postLeft > postRight) {
            return null;
        }
        // 后序遍历最后一个节点就是根节点
        TreeNode root = new TreeNode(postArr[postRight]);
        Integer rootIndex = hashMap.get(root.val);
        // 画图 左子树的区间 确实是 [postLeft, postLeft+rootIndex-midLeft-1]
        root.left = process(midLeft, rootIndex - 1, postLeft, postLeft + (rootIndex - midLeft) - 1);
        // 右子树索引 不能超过postRight
        root.right = process(rootIndex + 1, midRight, postLeft + (rootIndex - midLeft), postRight - 1);
        return root;
    }
}
