

//给你一个大小为 m x n 的二维整数网格 grid 和一个整数 x 。每一次操作，你可以对 grid 中的任一元素 加 x 或 减 x 。 
//
// 单值网格 是全部元素都相等的网格。 
//
// 返回使网格化为单值网格所需的 最小 操作数。如果不能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[2,4],[6,8]], x = 2
//输出：4
//解释：可以执行下述操作使所有元素都等于 4 ： 
//- 2 加 x 一次。
//- 6 减 x 一次。
//- 8 减 x 两次。
//共计 4 次操作。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[1,5],[2,3]], x = 1
//输出：5
//解释：可以使所有元素都等于 3 。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：grid = [[1,2],[3,4]], x = 2
//输出：-1
//解释：无法使所有元素相等。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10⁵ 
// 1 <= m * n <= 10⁵ 
// 1 <= x, grid[i][j] <= 10⁴ 
// 
// 👍 9 👎 0


package cn.db117.leetcode.util;

import java.util.Arrays;

/**
 * 2033.获取单值网格的最小操作数.minimum-operations-to-make-a-uni-value-grid
 *
 * @author db117
 * @since 2021-10-12 14:54:23
 **/

public class Solution_2033 {
    public static void main(String[] args) {
        Solution solution = new Solution_2033().new Solution();
        System.out.println(solution.minOperations(new int[][]
                        {{2, 4}, {6, 8}}
                , 2));
        System.out.println(solution.minOperations(new int[][]
                        {{1, 5}, {2, 3}}
                , 1));
        System.out.println(solution.minOperations(new int[][]
                        {{1, 2}, {3, 4}}
                , 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[][] grid, int x) {
            int len = grid.length * grid[0].length;
            int[] nums = new int[len];

            // 转为数组
            int index = 0;
            for (int[] ints : grid) {
                for (int i : ints) {
                    if ((i - grid[0][0]) % x != 0) {
                        // 不能变成一样的
                        return -1;
                    }
                    nums[index++] = i;
                }
            }

            Arrays.sort(nums);
            // 中位数
            int mid = nums[len / 2];

            // 1-2-3 都变成 1 和都变成 3 的距离都比变成 2 长
            // 找中位数即为最短距离
            int ans = 0;
            for (int num : nums) {
                ans += Math.abs(mid - num) / x;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}