package com.leetcode.daily;


/**
 * @Author: wangwu
 * @Date: Created in 9:53 2021/06/18
 * @Description:
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 *
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 *
 * 假设每一种面额的硬币有无限个。
 *
 * 题目数据保证结果符合 32 位带符号整数。
 *
 * 方法一：动态规划
 *
 * 这道题中，给定总金额 amount 和数组 coins，要求计算金额之和等于 amount 的硬币组合数。其中，coins 的每个元素可以选取多次，且不考虑选取元素的顺序，因此这道题需要计算的是选取硬币的组合数。
 *
 * 可以通过动态规划的方法计算可能的组合数。用 dp[x] 表示金额之和等于 xxx 的硬币组合数，目标是求 dp[amount]。
 *
 * 动态规划的边界是 dp[0]=1。只有当不选取任何硬币时，金额之和才为 0，因此只有 1 种硬币组合。
 *
 * 对于面额为coin 的硬币，当 coin≤i≤amount 时，如果存在一种硬币组合的金额之和等于 i−coin，则在该硬币组合中增加一个面额为 coin 的硬币，即可得到一种金额之和等于 i 的硬币组合。因此需要遍历 coins，对于其中的每一种面额的硬币，更新数组 dp 中的每个大于或等于该面额的元素的值。
 *
 * 由此可以得到动态规划的做法：
 *
 *     初始化 dp[0]=1；
 *
 *     遍历coins，对于其中的每个元素coin，进行如下操作：
 *         遍历 i 从coin 到 amount，将 dp[i−coin] 的值加到 dp[i]。
 *
 *     最终得到 dp[amount] 的值即为答案。
 *
 * 上述做法不会重复计算不同的排列。因为外层循环是遍历数组 coins 的值，内层循环是遍历不同的金额之和，在计算dp[i] 的值时，可以确保金额之和等于 i 的硬币面额的顺序，由于顺序确定，因此不会重复计算不同的排列。
 *
 * 例如，coins=[1,2]，对于 dp[3] 的计算，一定是先遍历硬币面额 1 后遍历硬币面额 2，只会出现以下 2 种组合：
 *
 * 3=1+1+1
 * 3 = 1+2
 *
 * 硬币面额 2 不可能出现在硬币面额 1 之前，即不会重复计算 3=2+1 的情况。
 *
 * #官方题解居然超时#
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/coin-change-2/solution/ling-qian-dui-huan-ii-by-leetcode-soluti-f7uh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class test518 {
	public static int change(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int coin : coins) {
			for (int i = coin; i <= amount; i++) {
				//这个i代表总金额,dp[i]代表所有coin组合出i的最大值，这里的i-coin的值=用当前coin或者比当前coin小的coin所组合的最大值
				//比方i=3，coin=2，那么3-2=1，那么只要看总金额为1有几种可能性，如果有一种可能性，那么i=3就必然也有一种，因为可以由总金额为1的那一种coin加上2的coin
				//思路就是遍历每个coin，然后计算单个coin组合成amount的次数，每次进行累加，最终就是最大值
				//如果coin从1开始，那么所有总金额都至少有一次，首先总金额为0有一次，总金额从1开始，1-coin1=0，那么就加上总金额的次数就等于1次，然后每个递增
				//的总金额总是加之前的次数，总是等于1
                //当总金额为2时，coin也为2时，那么总金额为2已经一次了，再加上1次，刚好两次,如果总金额为4时，就会加上2的两次，就是3次
				int i1 = dp[i - coin];
				dp[i] += i1;
			}
		}
		return dp[amount];
	}
//111111,11112,1122,222
	public static void main(String[] args) {
		int amount = 6;
		int[] coins = new int[]{1,2,3,4,5,6};
		int change = change(amount, coins);
		System.out.println(change);
	}
}
