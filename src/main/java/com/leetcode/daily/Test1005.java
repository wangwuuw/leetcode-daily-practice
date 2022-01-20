package com.leetcode.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangwu
 * @create: 2021-12-03
 * @description:
 */
public class Test1005 {
    public static void main(String[] args) {
        String s = String.format("%s%s",1,2);
        System.out.println(s);
        int[] two = {2,-3,-1,5,-4};
        int i = largestSumAfterKNegations(two, 2);
        System.out.println(i);
    }
    public static int largestSumAfterKNegations(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int ans = Arrays.stream(nums).sum();
        for (int i = -100; i < 0; ++i) {
            if (freq.containsKey(i)) {
                int ops = Math.min(k, freq.get(i));
                ans += (-i) * ops * 2;
                freq.put(i, freq.get(i) - ops);
                freq.put(-i, freq.getOrDefault(-i, 0) + ops);
                k -= ops;
                if (k == 0) {
                    break;
                }
            }
        }
        if (k > 0 && k % 2 == 1 && !freq.containsKey(0)) {
            for (int i = 1; i <= 100; ++i) {
                if (freq.containsKey(i)) {
                    ans -= i * 2;
                    break;
                }
            }
        }
        return ans;
    }
}
