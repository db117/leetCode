


//存在一个不含 0 的 环形 数组 nums ，每个 nums[i] 都表示位于下标 i 的角色应该向前或向后移动的下标个数： 
//
// 
// 如果 nums[i] 是正数，向前 移动 nums[i] 步 
// 如果 nums[i] 是负数，向后 移动 nums[i] 步 
// 
//
// 因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，而第一个元素向后移动一步会到达最后一个元素。 
//
// 数组中的 循环 由长度为 k 的下标序列 seq ： 
//
// 
// 遵循上述移动规则将导致重复下标序列 seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ... 
// 所有 nums[seq[j]] 应当不是 全正 就是 全负 
// k > 1 
// 
//
// 如果 nums 中存在循环，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,-1,1,2,2]
//输出：true
//解释：存在循环，按下标 0 -> 2 -> 3 -> 0 。循环长度为 3 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [-1,2]
//输出：false
//解释：按下标 1 -> 1 -> 1 ... 的运动无法构成循环，因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。
// 
//
// 示例 3: 
//
// 
//输入：nums = [-2,1,-1,-2,-2]
//输出：false
//解释：按下标 1 -> 2 -> 1 -> ... 的运动无法构成循环，因为 nums[1] 是正数，而 nums[2] 是负数。
//所有 nums[seq[j]] 应当不是全正就是全负。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -1000 <= nums[i] <= 1000 
// nums[i] != 0 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(n) 且额外空间复杂度为 O(1) 的算法吗？ 
// Related Topics 数组 双指针 
// 👍 86 👎 0


package cn.db117.leetcode.solution4;

/**
 * 457.环形数组是否存在循环.circular-array-loop
 *
 * @author db117
 * @since 2021-06-07 16:08:22
 **/

public class Solution_457 {
    public static void main(String[] args) {
        Solution solution = new Solution_457().new Solution();
        System.out.println(solution.circularArrayLoop(new int[]{
                2, -1, 1, 2, 2
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean circularArrayLoop(int[] nums) {
            // 数字要么在环中,要么不在环中
            // 原数组没有有0,使用0标记访问过

            // 快慢指针
            int slow, fast;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    // 已经扫描过了,不在环中
                    continue;
                }
                slow = i;
                fast = next(nums, i);

                // 保证都是同符号的
                while (nums[slow] * nums[fast] > 0 && nums[fast] * nums[next(nums, fast)] > 0) {

                    if (slow == fast) {
                        if (slow == next(nums, slow)) {
                            // 循环为1
                            break;
                        }
                        return true;
                    } else {
                        // 慢指针走一步
                        slow = next(nums, slow);
                        // 快指针走两步
                        fast = next(nums, next(nums, fast));
                    }
                }

                // 不在环中,肯定不符合题意
                int next = i;
                while (nums[i] != 0) {
                    int tmp = next(nums, next);
                    nums[next] = 0;
                    next = tmp;
                }
            }
            return false;
        }

        private int next(int[] nums, int cur) {
            int ans = (cur + nums[cur]) % nums.length;
            return ans >= 0 ? ans : ans + nums.length;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}