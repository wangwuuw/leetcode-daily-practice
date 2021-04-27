package com.leetcode.pattern;

/**
 * @Author: wangwu
 * @Date: Created in 16:49 2021/04/19
 * @Description:
 */
public class PatternExtendTest {
	public static void main(String[] args) {
		Pair<Integer> p = new Pair<>(123, 456);
		int n = add(p);
		System.out.println(n);
	}

	static int add(Pair<? extends Number> p) {
		Number first = p.getFirst();
		Number last = p.getLast();
		return first.intValue() + last.intValue();
	}
}
class Pair<T> {
	private T first;
	private T last;
	public Pair(T first, T last) {
		this.first = first;
		this.last = last;
	}
	public T getFirst() {
		return first;
	}
	public T getLast() {
		return last;
	}
}