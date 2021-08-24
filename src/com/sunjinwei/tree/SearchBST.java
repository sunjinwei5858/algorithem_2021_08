package com.sunjinwei.tree;

/**
 * bst中的搜索 力扣700
 * 给定二叉搜索树（BST）的根节点和一个值。
 * 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 */
public class SearchBST {

    /**
     * 利用bst可以进行二分 dfs
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return root;
        }
    }

    /**
     * 超级简单的迭代法 既不是用栈 也不是使用队列
     * 但是⼀些同学很容易忽略⼆叉搜索树的特性，所以写出遍历的代码就未必真的简单了。
     */
    public TreeNode searchBST2(TreeNode root, int val) {

        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}
