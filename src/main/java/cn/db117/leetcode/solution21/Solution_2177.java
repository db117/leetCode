

//给你一个整数 num ，请你返回三个连续的整数，它们的 和 为 num 。如果 num 无法被表示成三个连续整数的和，请你返回一个 空 数组。 
//
// 
//
// 示例 1： 
//
// 输入：num = 33
//输出：[10,11,12]
//解释：33 可以表示为 10 + 11 + 12 = 33 。
//10, 11, 12 是 3 个连续整数，所以返回 [10, 11, 12] 。
// 
//
// 示例 2： 
//
// 输入：num = 4
//输出：[]
//解释：没有办法将 4 表示成 3 个连续整数的和。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= num <= 10¹⁵ 
// 
// Related Topics 数学 模拟 👍 4 👎 0


package cn.db117.leetcode.solution21;

/**
 * 2177.找到和为给定整数的三个连续整数.find-three-consecutive-integers-that-sum-to-a-given-number
 *
 * @author db117
 * @since 2022-02-23 17:15:04
 **/

public class Solution_2177 {
    public static void main(String[] args) {
        Solution solution = new Solution_2177().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long[] sumOfThree(long num) {
            if (num % 3 != 0) {
                return new long[0];
            }
            long l = num / 3;
            return new long[]{l - 1, l, l + 1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}