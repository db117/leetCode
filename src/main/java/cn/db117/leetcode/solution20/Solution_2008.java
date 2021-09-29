

//你驾驶出租车行驶在一条有 n 个地点的路上。这 n 个地点从近到远编号为 1 到 n ，你想要从 1 开到 n ，通过接乘客订单盈利。你只能沿着编号递增的方
//向前进，不能改变方向。 
//
// 乘客信息用一个下标从 0 开始的二维数组 rides 表示，其中 rides[i] = [starti, endi, tipi] 表示第 i 位乘客需要从
//地点 starti 前往 endi ，愿意支付 tipi 元的小费。 
//
// 每一位 你选择接单的乘客 i ，你可以 盈利 endi - starti + tipi 元。你同时 最多 只能接一个订单。 
//
// 给你 n 和 rides ，请你返回在最优接单方案下，你能盈利 最多 多少元。 
//
// 注意：你可以在一个地点放下一位乘客，并在同一个地点接上另一位乘客。 
//
// 
//
// 示例 1： 
//
// 输入：n = 5, rides = [[2,5,4],[1,5,1]]
//输出：7
//解释：我们可以接乘客 0 的订单，获得 5 - 2 + 4 = 7 元。
// 
//
// 示例 2： 
//
// 输入：n = 20, rides = [[1,6,1],[3,10,2],[10,12,3],[11,12,2],[12,15,2],[13,18,1]]
//
//输出：20
//解释：我们可以接以下乘客的订单：
//- 将乘客 1 从地点 3 送往地点 10 ，获得 10 - 3 + 2 = 9 元。
//- 将乘客 2 从地点 10 送往地点 12 ，获得 12 - 10 + 3 = 5 元。
//- 将乘客 5 从地点 13 送往地点 18 ，获得 18 - 13 + 1 = 6 元。
//我们总共获得 9 + 5 + 6 = 20 元。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// 1 <= rides.length <= 3 * 10⁴ 
// rides[i].length == 3 
// 1 <= starti < endi <= n 
// 1 <= tipi <= 10⁵ 
// 
// Related Topics 数组 二分查找 动态规划 排序 👍 11 👎 0


package cn.db117.leetcode.solution20;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2008.出租车的最大盈利.maximum-earnings-from-taxi
 *
 * @author db117
 * @since 2021-09-29 11:56:47
 **/

public class Solution_2008 {
    public static void main(String[] args) {
        Solution solution = new Solution_2008().new Solution();

        System.out.println(solution.maxTaxiEarnings(20, new int[][]
                {{1, 6, 1}, {3, 10, 2}, {10, 12, 3}, {11, 12, 2}, {12, 15, 2}, {13, 18, 1}}
        ));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxTaxiEarnings(int n, int[][] rides) {
            long[] dp = new long[n + 1];
            // 以终点排序
            Arrays.sort(rides, Comparator.comparingInt(o -> o[1]));

            // 上一次走的位置
            int lastIndex = 0;
            for (int i = 1; i <= n; i++) {
                // 即没有载人的情况下的最大值
                dp[i] = dp[i - 1];
                while (lastIndex < rides.length && rides[lastIndex][1] <= i) {
                    int[] last = rides[lastIndex];
                    // 当前能赚到的钱
                    int cur = last[1] - last[0] + last[2];
                    // 计算前面能够做到的最大值
                    // 当前乘客能赚的钱，加上乘客上车钱能赚的最大值
                    dp[i] = Math.max(dp[i], cur + dp[last[0]]);
                    // 算过的就不算了
                    lastIndex++;
                }
            }
            return dp[n];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}