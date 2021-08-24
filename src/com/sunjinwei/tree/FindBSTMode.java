package com.sunjinwei.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树中的众数 力扣501
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 */
public class FindBSTMode {

    private List<Integer> res = new ArrayList<>();
    private int count = 0;
    private int maxCount = 0;
    private TreeNode pre;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        process(root);
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    /**
     * 二叉搜索树的中序遍历是一个升序序列，逐个比对当前结点(root)值与前驱结点（pre)值。
     * 更新当前节点值出现次数(curTimes)及最大出现次数(maxTimes)，
     * 更新规则：
     * 若curTimes=maxTimes,将root->val添加到结果向量(res)中；
     * 若curTimes>maxTimes,清空res,将root->val添加到res,并更新maxTimes为curTimes。
     * @param root
     */
    private void process(TreeNode root) {
        if (root == null) {
            return;
        }
        // 中序遍历：左子树
        process(root.left);
        // 中序遍历：根节点 逻辑处理
        // 1pre为null说明是根节点 count=1 即可
        if (pre == null) {
            count = 1;
        } else if (pre.val == root.val) {
            // 出现重复的值 加1
            count++;
        } else {
            // 否则重置
            count = 1;
        }
        // 更新pre
        pre = root;
        // 如果和最大值相同
        if (count == maxCount) {
            res.add(root.val);
        }
        // 如果比最大值更大，更新maxCount 清空res 加入
        if (count > maxCount) {
            maxCount = count;
            res.clear();
            res.add(root.val);
        }
        // 中序遍历：右子树
        process(root.right);
    }
}
