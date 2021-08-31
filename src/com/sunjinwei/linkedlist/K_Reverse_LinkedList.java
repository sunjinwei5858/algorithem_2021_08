package com.sunjinwei.linkedlist;

/**
 * k个一组反转链表 字节面试题
 */
public class K_Reverse_LinkedList {

    /**
     * 递归
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // 记录反转之后下一个需要反转的头节点
        ListNode next = head;
        // 记录反转之后这部分链表的尾巴
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (next == null) {
                return head;
            }
            next = next.next;
        }
        // 反转链表
        ListNode res = reverse(tail, next);
        // 递归处理后面的节点
        tail.next = reverseKGroup(next, k);
        return res;
    }

    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode pre = null;
        ListNode curr = begin;
        ListNode tem = null;
        while (curr != null && curr != end) {
            tem = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tem;
        }
        return pre;
    }

    /**
     * 迭代法: 使用哨兵节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode shaobing = new ListNode(-1);
        shaobing.next = head;
        // 一段一段来处理
        ListNode pre = shaobing;
        // 记录反转前的begin节点
        ListNode begin = head;
        // 记录第k个节点的next节点 左闭右开区间
        ListNode curr = head;
        while (curr != null) {
            // 提前记录
            begin = curr;
            for (int i = 0; i < k; i++) {
                if (curr == null) {
                    return shaobing.next;
                }
                curr = curr.next;
            }
            // 调整指针 pre和反转之后的
            pre.next = reverse(begin, curr);
            // 调整指针 反转好的和将要反转的
            begin.next = curr;
            pre = curr;
        }
        return shaobing.next;
    }


}
