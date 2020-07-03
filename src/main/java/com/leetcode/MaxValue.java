package com.leetcode;

import java.util.ArrayList;

class MaxValue {
    /**
     * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、
     * 直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param grid
     * @return
     * 示例 1:
     *
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,7],
     *   [4,10,1]
     * ]
     * 输出: 12
     * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
     *
     *
     *
     * 提示：
     *
     *     0 < grid.length <= 200
     *     0 < grid[0].length <= 200
     */
    /**
     *解题思路：每一步都把之前最大的数进行累加
     * @param grid
     * @return
     */
    public static int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i<m; i++)
            for(int j = 0; j<n; j++)
                // 更新这一格能获得的最大礼物,当然，是这个函数关键的一个地方
            {
                /**
                 *      * 输入:
                 *      * [
                 *      *   [1,3,1],
                 *      *   [1,5,7],
                 *      *   [4,10,1]
                 *      * ]
                 */
                int i1 = maxNeighbour(grid, i, j);
                grid[i][j] += i1;

            }
        return grid[m-1][n-1]; // 看，很巧妙吧
    }

    // 从左边和上边找最大的一个， 当然有一些边界条件需要判断
    public static int  maxNeighbour(int[][] grid, int i, int j){
        if(i == 0 && j == 0) return 0;
        if(i == 0) {
            int i1 = grid[i][j - 1];
            return i1;

        }
        /**
         *      * 输入:
         *      * [
         *      *   [1,3,1],
         *      *   [1,5,7],
         *      *   [4,10,1]
         *      * ]
         */
        if(j == 0) {
            int i1 = grid[i - 1][j];
            return i1;

        }
        // 这个函数其实语义就这一行，上面只是一些边界判断
        return Math.max(grid[i-1][j], grid[i][j-1]);
    }


    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3,1},{1,5,7},{4,10,1}};
        int i = maxValue(grid);
        System.out.println(i);
    }
}