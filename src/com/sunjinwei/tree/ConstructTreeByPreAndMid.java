package com.sunjinwei.tree;

import java.util.HashMap;

/**
 * 根据前序和中序构造 【力扣105】
 */
public class ConstructTreeByPreAndMid {

    public int[] preArr;
    public int[] midArr;
    public HashMap<Integer, Integer> hashMap;

    /**
     * 左闭右闭
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        this.hashMap = new HashMap<>();
        this.preArr = preorder;
        this.midArr = inorder;

        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        // 左闭右闭
        return process(0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode process(int preLeft, int preRight, int midLeft, int midRight) {
        if (preLeft > preRight || midLeft > midRight) {
            return null;
        }
        TreeNode root = new TreeNode(preArr[preLeft]);
        Integer rootIndex = hashMap.get(root.val);
        root.left = process(preLeft + 1, preLeft + (rootIndex - midLeft), midLeft, rootIndex - 1);
        root.right = process(preLeft + (rootIndex - midLeft) + 1, preRight, rootIndex + 1, midRight);
        return root;
    }
}
