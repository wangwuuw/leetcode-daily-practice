package com.leetcode.mian_shi_jing_dian;

/**
 * @Author: wangwu
 * @Date: Created in 16:33 2021/09/18
 * @Description:实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 */
public class Test1 {
	public static void main(String[] args) {

	}
	public static boolean  isUnique(String str){
		char[] chars = str.toCharArray();
		for (char c:chars){
			return str.indexOf(c)!=-1;
		}
		return true;

	}

}
