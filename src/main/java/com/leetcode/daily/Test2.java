package com.leetcode.daily;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: wangwu
 * @Date: Created in 18:18 2021/09/27
 * @Description: 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 123 + 123 = 246 642
 */
public class Test2 {
	private static String num1 = "";
	private static String num2 = "";
	public static void main(String[] args) {
		int[] one = {9};
		ListNode listNode = get(one);
		int[] two = {9, 9, 9, 9, 9, 9, 9, 9, 9,1};
		ListNode listNode1 = get(two);
		addTwoNumbers(listNode,listNode1);

	}
	public static ListNode get(int[] ints){
		ListNode tail = new ListNode();
		for (int i = 0; i <=  ints.length-1; i++) {
			tail.val = ints[i];
			ListNode pre = new ListNode();
			pre.next = tail;
			tail = pre;
		}
		tail = tail.next;
		return tail;
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null, tail = null;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int n1 = l1 != null ? l1.val : 0;
			int n2 = l2 != null ? l2.val : 0;
			int sum = n1 + n2 + carry;
			if (head == null) {
				head = tail = new ListNode(sum % 10);
			} else {
				tail.next = new ListNode(sum % 10);
				tail = tail.next;
			}
			carry = sum / 10;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (carry > 0) {
			tail.next = new ListNode(carry);
		}
		return head;
	}
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
