package com.sunjinwei.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层序遍历【字节面试题】
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        boolean flag = true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 在添加的时候 进行逻辑处理 层序遍历正常进行
                if (flag) {
                    // 正常添加 添加到队列的尾巴
                    list.add(node.val);
                } else {
                    // 将元素添加到队首
                    list.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            flag = !flag;
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();

        integers.offerLast(1);
        integers.offerLast(2);
        integers.offerLast(3);

        System.out.println(integers.toString());
    }
}
