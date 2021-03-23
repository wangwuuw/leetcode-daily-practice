package com.leetcode.linked;

/**
 * @Author: wangwu
 * @Date: Created in 10:15 2021/02/03
 * @Description:
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 */
public class ReverseLinkedList {
	public static void main(String[] args) {
		ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
		ListNode listNode = reverseLinkedList.createListNode();
		ListNode listNode1 = reverseLinkedList.reverseList(listNode);
		System.out.println(listNode1);
	}

	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null){
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	ListNode  createListNode(){
		ListNode listNode = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		ListNode listNode6 = null;
		listNode.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		listNode5.next = listNode6;
        return listNode;
	}

}
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
