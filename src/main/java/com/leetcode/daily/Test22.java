package com.leetcode.daily;

import com.leetcode.daily.entity.ListNode;

/**
 * @author: wangwu
 * @create: 2021-12-15
 * @description:合并两个有序链表
 */
public class Test22 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode1 = mergeTwoLists(listNode, listNode2);
        System.out.println(listNode1);
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
