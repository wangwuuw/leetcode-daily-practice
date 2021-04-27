package com.leetcode.pattern;

/**
 * @Author: wangwu
 * @Date: Created in 16:56 2021/04/19
 * @Description:
 */
public class PatternSuperTest {
	public static void main(String[] args) {
		Pair2<Number> p1 = new Pair2<>(12.3, 4.56);
		Pair2<Integer> p2 = new Pair2<>(123, 456);
		setSame(p1, 100);
		setSame(p2, 200);
		System.out.println(p1.getFirst() + ", " + p1.getLast());
		System.out.println(p2.getFirst() + ", " + p2.getLast());
	}

	static void setSame(Pair2<? super Integer> p, Integer n) {
		Object first = p.getFirst();
		p.setFirst(n);
		p.setLast(n);
	}

}
class Pair2<T> {
	private T first;
	private T last;

	public Pair2(T first, T last) {
		this.first = first;
		this.last = last;
	}

	public T getFirst() {
		return first;
	}
	public T getLast() {
		return last;
	}
	public void setFirst(T first) {
		this.first = first;
	}
	public void setLast(T last) {
		this.last = last;
	}
}
