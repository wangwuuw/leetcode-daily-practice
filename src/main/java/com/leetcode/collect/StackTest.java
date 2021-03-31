package com.leetcode.collect;

import java.util.Stack;

/**
 * @Author: wangwu
 * @Date: Created in 16:47 2021/03/19
 * @Description:
 */
public class StackTest {
	public static void main(String[] args) {
		Stack<String> stack = new Stack();
		stack.add("1");
		stack.add("2");
		stack.add("3");
		stack.add("4");
		stack.add("5");
		String peek = stack.peek();
		stack.pop();
		System.out.println(peek);
		System.out.println(peek);

	}
}
