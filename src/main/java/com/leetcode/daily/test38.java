package com.leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: wangwu
 * @Date: Created in 15:05 2021/06/22
 * @Description:
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * 限制：
 *
 * 1 <= s 的长度 <= 8
 */
public class test38 {
	static List<String> res = new ArrayList<>();

	public static String[] permutation(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		backtrack(chars, new boolean[chars.length], new StringBuffer());
		return res.toArray(new String[0]);
	}

	private static void backtrack(char[] chars, boolean[] visited, StringBuffer buffer) {
		if (buffer.length() == chars.length) {
			res.add(buffer.toString());
		}
		for (int i = 0; i < chars.length; i++) {
			if (visited[i]) continue;
			if (i > 0 && !visited[i - 1] && chars[i - 1] == chars[i]) continue;
			visited[i] = true;
			buffer.append(chars[i]);
			backtrack(chars, visited, buffer);
			buffer.deleteCharAt(buffer.length() - 1);
			visited[i] = false;
		}
	}


	public static void main(String[] args) {
		String[] abcdes = permutation("aab");
		System.out.println(Arrays.toString(abcdes));
	}

}
