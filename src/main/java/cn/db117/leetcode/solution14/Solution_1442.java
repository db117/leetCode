// 给你一个整数数组 arr 。
//
// 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。 
//
// a 和 b 定义如下： 
//
// 
// a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1] 
// b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k] 
// 
//
// 注意：^ 表示 按位异或 操作。 
//
// 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [2,3,1,6,7]
//输出：4
//解释：满足题意的三元组分别是 (0,1,2), (0,2,2), (2,3,4) 以及 (2,4,4)
// 
//
// 示例 2： 
//
// 输入：arr = [1,1,1,1,1]
//输出：10
// 
//
// 示例 3： 
//
// 输入：arr = [2,3]
//输出：0
// 
//
// 示例 4： 
//
// 输入：arr = [1,3,5,7,9]
//输出：3
// 
//
// 示例 5： 
//
// 输入：arr = [7,11,12,9,5,2,7,17,22]
//输出：8
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 300 
// 1 <= arr[i] <= 10^8 
// 
// Related Topics 位运算 数组 数学 
// 👍 168 👎 0


package cn.db117.leetcode.solution14;

/**
 * 1442.形成两个异或相等数组的三元组数目.count-triplets-that-can-form-two-arrays-of-equal-xor
 *
 * @author db117
 * @since 2021-06-04 11:18:32
 **/

public class Solution_1442 {
    public static void main(String[] args) {
        Solution solution = new Solution_1442().new Solution();
        System.out.println(solution.countTriplets(new int[]{
                7, 11, 12, 9, 5, 2, 7, 17, 22
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countTriplets(int[] arr) {
            // 如果 a==b 则 a^b=0
            int ans = 0;
            // 前缀和
            int[] tmp = new int[arr.length + 1];
            for (int i = 1; i <= arr.length; i++) {
                tmp[i] = tmp[i - 1] ^ arr[i - 1];
            }

            for (int i = 1; i <= arr.length; i++) {
                for (int k = i + 1; k <= arr.length; k++) {
                    if (tmp[i - 1] == tmp[k]) {
                        // j 在 (i,k] 中都可以满足条件,即有 k-i 中可能
                        ans += k - i;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}