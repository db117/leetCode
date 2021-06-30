//给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
//
// 注意： 
//数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。 
//
// 示例: 
//
// 
//int[] nums = new int[] {1,2,3,3,3};
//Solution solution = new Solution(nums);
//
//// pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
//solution.pick(3);
//
//// pick(1) 应该返回 0。因为只有nums[0]等于1。
//solution.pick(1);
// 
// Related Topics 水塘抽样 哈希表 数学 随机化 
// 👍 112 👎 0


package cn.db117.leetcode.solution3;

import java.util.Random;

/**
 * 398.随机数索引.random-pick-index
 *
 * @author db117
 * @since 2021-06-30 11:28:34
 **/

public class Solution_398 {
    public static void main(String[] args) {
        Solution solution = new Solution_398().new Solution(new int[]{

        });
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            Random random = new Random();
            //  蓄水池抽样算法（Reservoir Sampling）
            int count = 1;
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                if (target == nums[i]) {
                    // 相当于对已经找到的数字进行随机抽取
                    if (random.nextInt(count++) == 0) {
                        res = i;
                    }
                }
            }
            return res;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
//leetcode submit region end(Prohibit modification and deletion)

}