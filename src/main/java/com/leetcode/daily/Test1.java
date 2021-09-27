package com.leetcode.daily;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: wangwu
 * @Date: Created in 16:02 2021/09/23
 * @Description:
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test1 {
	public static void main(String[] args) {
		int[] ints = twoSum(new int[]{3,3}, 6);
		System.out.println(Arrays.toString(ints));

	}
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i=0;nums.length>0;i++){
			Integer index = map.get(target - nums[i]);
			if (index!=null) {
				return new int[]{i,index};
			}
			map.put(nums[i],i);
		}
		return null;
	}
}
