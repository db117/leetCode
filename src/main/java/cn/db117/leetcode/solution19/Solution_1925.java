

//一个 平方和三元组 (a,b,c) 指的是满足 a² + b² = c² 的 整数 三元组 a，b 和 c 。 
//
// 给你一个整数 n ，请你返回满足 1 <= a, b, c <= n 的 平方和三元组 的数目。 
//
// 
//
// 示例 1： 
//
// 输入：n = 5
//输出：2
//解释：平方和三元组为 (3,4,5) 和 (4,3,5) 。
// 
//
// 示例 2： 
//
// 输入：n = 10
//输出：4
//解释：平方和三元组为 (3,4,5)，(4,3,5)，(6,8,10) 和 (8,6,10) 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 250 
// 
// Related Topics 数学 枚举 👍 6 👎 0


package cn.db117.leetcode.solution19;

import java.util.HashSet;
import java.util.Set;

/**
 * 1925.统计平方和三元组的数目.count-square-sum-triples
 *
 * @author db117
 * @since 2021-09-29 18:02:30
 **/

public class Solution_1925 {
    public static void main(String[] args) {
        Solution solution = new Solution_1925().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countTriples(int n) {
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                set.add(i * i);
            }

            int ans = 0;
            for (Integer i : set) {
                for (Integer j : set) {
                    // 存在 a² + b² = c²
                    if (set.contains(i + j)) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}