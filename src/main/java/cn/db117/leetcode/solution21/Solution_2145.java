

//给你一个下标从 0 开始且长度为 n 的整数数组 differences ，它表示一个长度为 n + 1 的 隐藏 数组 相邻 元素之间的 差值 。更正式的
//表述为：我们将隐藏数组记作 hidden ，那么 differences[i] = hidden[i + 1] - hidden[i] 。 
//
// 同时给你两个整数 lower 和 upper ，它们表示隐藏数组中所有数字的值都在 闭 区间 [lower, upper] 之间。 
//
// 
// 比方说，differences = [1, -3, 4] ，lower = 1 ，upper = 6 ，那么隐藏数组是一个长度为 4 且所有值都在 1 和
// 6 （包含两者）之间的数组。
//
// 
// [3, 4, 1, 5] 和 [4, 5, 2, 6] 都是符合要求的隐藏数组。 
// [5, 6, 3, 7] 不符合要求，因为它包含大于 6 的元素。 
// [1, 2, 3, 4] 不符合要求，因为相邻元素的差值不符合给定数据。 
// 
// 
// 
//
// 请你返回 符合 要求的隐藏数组的数目。如果没有符合要求的隐藏数组，请返回 0 。 
//
// 
//
// 示例 1： 
//
// 输入：differences = [1,-3,4], lower = 1, upper = 6
//输出：2
//解释：符合要求的隐藏数组为：
//- [3, 4, 1, 5]
//- [4, 5, 2, 6]
//所以返回 2 。
// 
//
// 示例 2： 
//
// 输入：differences = [3,-4,5,1,-2], lower = -4, upper = 5
//输出：4
//解释：符合要求的隐藏数组为：
//- [-3, 0, -4, 1, 2, 0]
//- [-2, 1, -3, 2, 3, 1]
//- [-1, 2, -2, 3, 4, 2]
//- [0, 3, -1, 4, 5, 3]
//所以返回 4 。
// 
//
// 示例 3： 
//
// 输入：differences = [4,-7,2], lower = 3, upper = 6
//输出：0
//解释：没有符合要求的隐藏数组，所以返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// n == differences.length 
// 1 <= n <= 10⁵ 
// -10⁵ <= differences[i] <= 10⁵ 
// -10⁵ <= lower <= upper <= 10⁵ 
// 
// 👍 6 👎 0


package cn.db117.leetcode.solution21;

/**
 * 2145.统计隐藏数组数目.count-the-hidden-sequences
 *
 * @author db117
 * @since 2022-01-25 18:28:01
 **/

public class Solution_2145 {
    public static void main(String[] args) {
        Solution solution = new Solution_2145().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfArrays(int[] differences, int lower, int upper) {
            long max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            long[] arr = new long[differences.length + 1];
            // 默认第一个为 0,计算最大最小值
            // 在比较求差

            for (int i = 0; i < arr.length; i++) {
                if (i > 0) {
                    arr[i] = arr[i - 1] + differences[i - 1];
                }
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i]);
            }


            return (int) Math.max(0, (upper - lower) - (max - min) + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}