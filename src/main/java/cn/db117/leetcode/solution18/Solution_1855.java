//给你两个 非递增 的整数数组 nums1 和 nums2 ，数组下标均 从 0 开始 计数。
//
// 下标对 (i, j) 中 0 <= i < nums1.length 且 0 <= j < nums2.length 。如果该下标对同时满足 i <= j
// 且 nums1[i] <= nums2[j] ，则称之为 有效 下标对，该下标对的 距离 为 j - i 。 
//
// 返回所有 有效 下标对 (i, j) 中的 最大距离 。如果不存在有效下标对，返回 0 。 
//
// 一个数组 arr ，如果每个 1 <= i < arr.length 均有 arr[i-1] >= arr[i] 成立，那么该数组是一个 非递增 数组。 
//
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [55,30,5,4,2], nums2 = [100,20,10,10,5]
//输出：2
//解释：有效下标对是 (0,0), (2,2), (2,3), (2,4), (3,3), (3,4) 和 (4,4) 。
//最大距离是 2 ，对应下标对 (2,4) 。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [2,2,2], nums2 = [10,10,1]
//输出：1
//解释：有效下标对是 (0,0), (0,1) 和 (1,1) 。
//最大距离是 1 ，对应下标对 (0,1) 。 
//
// 示例 3： 
//
// 
//输入：nums1 = [30,29,19,5], nums2 = [25,25,25,25,25]
//输出：2
//解释：有效下标对是 (2,2), (2,3), (2,4), (3,3) 和 (3,4) 。
//最大距离是 2 ，对应下标对 (2,4) 。
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [5,4], nums2 = [3,2]
//输出：0
//解释：不存在有效下标对，所以返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= 105 
// 1 <= nums2.length <= 105 
// 1 <= nums1[i], nums2[j] <= 105 
// nums1 和 nums2 都是 非递增 数组 
// 
// Related Topics 贪心算法 数组 双指针 二分查找 
// 👍 11 👎 0


package cn.db117.leetcode.solution18;

/**
 * 1855.下标对中的最大距离.maximum-distance-between-a-pair-of-values
 *
 * @author db117
 * @since 2021-06-24 10:46:45
 **/

public class Solution_1855 {
    public static void main(String[] args) {
        Solution solution = new Solution_1855().new Solution();

        System.out.println(solution.maxDistance(new int[]{
                55, 30, 5, 4, 2
        }, new int[]{
                100, 20, 10, 10, 5
        }));
        System.out.println(solution.maxDistance(new int[]{
                2, 2, 2
        }, new int[]{
                10, 10, 1
        }));
        System.out.println(solution.maxDistance(new int[]{
                30, 29, 19, 5
        }, new int[]{
                25, 25, 25, 25, 25
        }));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxDistance(int[] nums1, int[] nums2) {
            int index1 = 0, index2 = 0;
            int max = 0;

            while (index1 < nums1.length && index2 < nums2.length) {
                while (index1 < nums1.length && nums1[index1] > nums2[index2]) {
                    index1++;
                }
                if (index1 == nums1.length) {
                    // 到头了
                    break;
                }

                // nums2 的索引位置大于等于 nums1
                if (index1 > index2) {
                    index2 = index1;
                }

                while (index2 < nums2.length && nums1[index1] <= nums2[index2]) {
                    index2++;
                }

                max = Math.max(max, index2 - 1 - index1);
            }

            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}