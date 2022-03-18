

//给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。 
//
// 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。 
//
// 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎
//，则可以在之后的操作中 重复使用 这枚鸡蛋。 
//
// 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？ 
// 
//
// 示例 1： 
//
// 
//输入：k = 1, n = 2
//输出：2
//解释：
//鸡蛋从 1 楼掉落。如果它碎了，肯定能得出 f = 0 。 
//否则，鸡蛋从 2 楼掉落。如果它碎了，肯定能得出 f = 1 。 
//如果它没碎，那么肯定能得出 f = 2 。 
//因此，在最坏的情况下我们需要移动 2 次以确定 f 是多少。 
// 
//
// 示例 2： 
//
// 
//输入：k = 2, n = 6
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：k = 3, n = 14
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 100 
// 1 <= n <= 10⁴ 
// 
// Related Topics 数学 二分查找 动态规划 👍 760 👎 0


package cn.db117.leetcode.solution8;

/**
 * 887.鸡蛋掉落.super-egg-drop
 *
 * @author db117
 * @since 2022-03-18 14:51:45
 **/

public class Solution_887 {
    public static void main(String[] args) {
        Solution solution = new Solution_887().new Solution();
        System.out.println(solution.superEggDrop(1, 2));
        System.out.println(solution.superEggDrop(2, 6));
        System.out.println(solution.superEggDrop(3, 14));

        System.out.println(solution.superEggDrop(2, 3));// 2
        System.out.println(solution.superEggDrop(2, 7));// 4
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int superEggDrop(int k, int n) {
            if (k == 1) {
                return n;
            }
            if (n == 1) {
                return 1;
            }
            // 动态规划

            // i 个鸡蛋可以扔 j 次,最多到几层楼
            int[][] dp = new int[k + 1][n + 1];

            for (int j = 1; j <= n; j++) {
                for (int i = 1; i <= k; i++) {

                    // 每扔一次都可以确定楼上或楼下的层数
                    // dp[i][j - 1]         蛋没有碎,次数变少了  楼上的层数(还有 i 个蛋,和 j-1 次可以试)
                    // dp[i - 1][j - 1]     蛋碎了,次数边少了  楼下的层数(还有 i-1 个单,和 j-1 次可以试)
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1] + 1;

                    // 能扔到目标楼层
                    if (dp[i][j] >= n) {
                        return j;
                    }
                }
            }


            return n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}