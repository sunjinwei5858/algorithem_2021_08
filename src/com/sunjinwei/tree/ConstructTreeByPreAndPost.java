package com.sunjinwei.tree;

import java.util.HashMap;

/**
 * 根据前序和后序构造二叉树 【力扣889】
 * 返回与给定的前序和后序遍历匹配的任何二叉树。
 */
public class ConstructTreeByPreAndPost {

    public int[] preArr;
    public int[] postArr;
    public HashMap<Integer, Integer> hashMap;

    /***
     * 左闭右闭
     * @param preorder
     * @param postorder
     * @return
     */
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder == null || postorder == null || preorder.length == 0 || postorder.length == 0) {
            return null;
        }
        this.hashMap = new HashMap<>();
        this.postArr = postorder;
        this.preArr = preorder;
        for (int i = 0; i < postorder.length; i++) {
            hashMap.put(postorder[i], i);
        }
        // 左闭右闭
        return process(0, preorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode process(int preLeft, int preRight, int postLeft, int postRight) {
        if (preLeft > preRight || postLeft > postRight) {
            return null;
        }
        // 前序遍历第一个节点就是根节点 也就是后序遍历最后一个节点
        TreeNode root = new TreeNode(preArr[preLeft]);
        // 因为前序和后序是根据前序第二个节点来找出后序对应的节点 所以这里要提前判断一下 后序的preLeft+1会索引越界!!!!!!
        if (preLeft == preRight) {
            return root;
        }
        // 利用后序数组找到左子树有多少个节点
        // 因为前序第二个节点 找到后序对应的索引 就可以推出 左子树有多少个节点
        // 此时的leftIndex就是左子树的节点个数
        Integer leftIndex = hashMap.get(preArr[preLeft + 1]);
        root.left = process(preLeft + 1, preLeft + 1 + (leftIndex - postLeft), postLeft, leftIndex);
        root.right = process(preLeft + 1 + (leftIndex - postLeft) + 1, preRight, leftIndex + 1, postRight);
        return root;
    }
}
