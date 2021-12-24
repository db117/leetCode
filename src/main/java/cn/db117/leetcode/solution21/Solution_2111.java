

//给你一个下标从 0 开始包含 n 个正整数的数组 arr ，和一个正整数 k 。 
//
// 如果对于每个满足 k <= i <= n-1 的下标 i ，都有 arr[i-k] <= arr[i] ，那么我们称 arr 是 K 递增 的。 
//
// 
// 比方说，arr = [4, 1, 5, 2, 6, 2] 对于 k = 2 是 K 递增的，因为：
//
// 
// arr[0] <= arr[2] (4 <= 5) 
// arr[1] <= arr[3] (1 <= 2) 
// arr[2] <= arr[4] (5 <= 6) 
// arr[3] <= arr[5] (2 <= 2) 
// 
// 
// 但是，相同的数组 arr 对于 k = 1 不是 K 递增的（因为 arr[0] > arr[1]），对于 k = 3 也不是 K 递增的（因为 arr[
//0] > arr[3] ）。 
// 
//
// 每一次 操作 中，你可以选择一个下标 i 并将 arr[i] 改成任意 正整数。 
//
// 请你返回对于给定的 k ，使数组变成 K 递增的 最少操作次数 。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [5,4,3,2,1], k = 1
//输出：4
//解释：
//对于 k = 1 ，数组最终必须变成非递减的。
//可行的 K 递增结果数组为 [5,6,7,8,9]，[1,1,1,1,1]，[2,2,3,4,4] 。它们都需要 4 次操作。
//次优解是将数组变成比方说 [6,7,8,9,10] ，因为需要 5 次操作。
//显然我们无法使用少于 4 次操作将数组变成 K 递增的。
// 
//
// 示例 2： 
//
// 输入：arr = [4,1,5,2,6,2], k = 2
//输出：0
//解释：
//这是题目描述中的例子。
//对于每个满足 2 <= i <= 5 的下标 i ，有 arr[i-2] <= arr[i] 。
//由于给定数组已经是 K 递增的，我们不需要进行任何操作。 
//
// 示例 3： 
//
// 输入：arr = [4,1,5,2,6,2], k = 3
//输出：2
//解释：
//下标 3 和 5 是仅有的 3 <= i <= 5 且不满足 arr[i-3] <= arr[i] 的下标。
//将数组变成 K 递增的方法之一是将 arr[3] 变为 4 ，且将 arr[5] 变成 5 。
//数组变为 [4,1,5,4,6,5] 。
//可能有其他方法将数组变为 K 递增的，但没有任何一种方法需要的操作次数小于 2 次。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10⁵ 
// 1 <= arr[i], k <= arr.length 
// 
// Related Topics 数组 二分查找 👍 25 👎 0


package cn.db117.leetcode.solution21;

/**
 * 2111.使数组 K 递增的最少操作次数.minimum-operations-to-make-the-array-k-increasing
 *
 * @author db117
 * @since 2021-12-22 16:03:38
 **/

public class Solution_2111 {
    public static void main(String[] args) {
        Solution solution = new Solution_2111().new Solution();

        System.out.println(solution.kIncreasing(new int[]{5, 4, 3, 2, 1}, 1));
        System.out.println(solution.kIncreasing(new int[]{4, 1, 5, 2, 6, 2}, 2));
        System.out.println(solution.kIncreasing(new int[]{4, 1, 5, 2, 6, 2}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kIncreasing(int[] arr, int k) {
            int ans = 0;
            // 最长上升子序列（Longest  Increasing Subsequence）
            for (int i = 0; i < k; i++) {
                int[] lis = new int[(arr.length + k) / k];
                int index = 0;// 子序列长度,下一个要写入的索引
                int count = 0;
                for (int j = i; j < arr.length; j += k) {
                    count++;
                    if (index == 0) {
                        // 初始化子序列
                        lis[index++] = arr[j];
                        continue;
                    }

                    // 大于等于前面的,直接添加到后面
                    if (arr[j] >= lis[index - 1]) {
                        lis[index++] = arr[j];
                        continue;
                    }

                    // 否则找到第一个大于当前值的,并更新
                    int bs = bs(lis, index - 1, arr[j]);
                    lis[bs] = arr[j];
                }
                // 不在最长上升子序列中的需要替换掉
                ans += count - index;
            }
            return ans;
        }

        // 第一个大于目标的值
        public int bs(int[] arr, int right, int key) {
            int left = 0;
            while (left < right) {
                // 找左边中位数
                int mid = (left + right) / 2;
                if (arr[mid] <= key) {
                    // 等于继续找右边的
                    left = mid + 1;
                } else {
                    // 可能是目标
                    right = mid;
                }
            }

            return right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}