

//
//
// 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿
//过地下城并通过对抗恶魔来拯救公主。 
//
// 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。 
//
// 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么
//包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。 
//
// 为了尽快到达公主，骑士决定每次只向右或向下移动一步。 
//
// 
//
// 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。 
//
// 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。 
//
// 
// 
// -2 (K) 
// -3 
// 3 
// 
// 
// -5 
// -10 
// 1 
// 
// 
// 10 
// 30 
// -5 (P) 
// 
// 
//
//
// 
//
// 说明: 
//
// 
// 
// 骑士的健康点数没有上限。 
// 
// 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。 
// Related Topics 数组 动态规划 矩阵 👍 589 👎 0


package cn.db117.leetcode.solution1;

/**
 * 174.地下城游戏.dungeon-game
 *
 * @author db117
 * @since 2022-03-16 14:49:40
 **/

public class Solution_174 {
    public static void main(String[] args) {
        Solution solution = new Solution_174().new Solution();
        System.out.println(solution.calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));
        System.out.println(solution.calculateMinimumHP(new int[][]{{0, 0}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            int m = dungeon.length, n = dungeon[0].length;
            // 到达公主处最少血量
            int[][] dp = new int[m][n];

            // 从公主处开始
            // 保证到达该处是血量大于 0
            dp[m - 1][n - 1] = dungeon[m - 1][n - 1] >= 0 ? 1 : -dungeon[m - 1][n - 1] + 1;

            // 动态规划
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (i == m - 1 && j == n - 1) {
                        continue;
                    }
                    // 从上边或左边选择一个最小的
                    // 前面需要的最少血量
                    int min;
                    if (i + 1 == m) {
                        // 最下面一行,找右边
                        min = dp[i][j + 1];
                    } else if (j + 1 == n) {
                        // 最右边一列,找下面
                        min = dp[i + 1][j];
                    } else {
                        min = Math.min(dp[i][j + 1], dp[i + 1][j]);
                    }

                    // 加上当前格子需要的血量 +(-)
                    dp[i][j] = min - dungeon[i][j];
                    // 保证改处是血量大于 0,且能走到公主处的最小值
                    // 需要的血量小于等于 0,说明当前格子血量比较多,但是为了保证前面不能死则进入当前格子血量需要为 1
                    dp[i][j] = dp[i][j] <= 0 ? 1 : dp[i][j];
                }
            }

            return dp[0][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}