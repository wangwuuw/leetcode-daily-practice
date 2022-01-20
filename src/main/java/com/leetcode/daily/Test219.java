package com.leetcode.daily;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: wangwu
 * @create: 2022-01-20
 * @description:
 */
public class Test219 {
    public static void main(String[] args) {

    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])&&i-map.get(nums[i])<=k) {
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
}
