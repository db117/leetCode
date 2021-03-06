// 给你两个字符串 s 和 p ，其中 p 是 s 的一个 子序列 。同时，给你一个元素 互不相同 且下标 从 0 开始 计数的整数数组 removable ，
//该数组是 s 中下标的一个子集（s 的下标也 从 0 开始 计数）。 
//
// 请你找出一个整数 k（0 <= k <= removable.length），选出 removable 中的 前 k 个下标，然后从 s 中移除这些下标对
//应的 k 个字符。整数 k 需满足：在执行完上述步骤后， p 仍然是 s 的一个 子序列 。更正式的解释是，对于每个 0 <= i < k ，先标记出位于 s[
//removable[i]] 的字符，接着移除所有标记过的字符，然后检查 p 是否仍然是 s 的一个子序列。 
//
// 返回你可以找出的 最大 k ，满足在移除字符后 p 仍然是 s 的一个子序列。 
//
// 字符串的一个 子序列 是一个由原字符串生成的新字符串，生成过程中可能会移除原字符串中的一些字符（也可能不移除）但不改变剩余字符之间的相对顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcacb", p = "ab", removable = [3,1,0]
//输出：2
//解释：在移除下标 3 和 1 对应的字符后，"abcacb" 变成 "accb" 。
//"ab" 是 "accb" 的一个子序列。
//如果移除下标 3、1 和 0 对应的字符后，"abcacb" 变成 "ccb" ，那么 "ab" 就不再是 s 的一个子序列。
//因此，最大的 k 是 2 。
// 
//
// 示例 2： 
//
// 
//输入：s = "abcbddddd", p = "abcd", removable = [3,2,1,4,5,6]
//输出：1
//解释：在移除下标 3 对应的字符后，"abcbddddd" 变成 "abcddddd" 。
//"abcd" 是 "abcddddd" 的一个子序列。
// 
//
// 示例 3： 
//
// 
//输入：s = "abcab", p = "abc", removable = [0,1,2,3,4]
//输出：0
//解释：如果移除数组 removable 的第一个下标，"abc" 就不再是 s 的一个子序列。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= p.length <= s.length <= 105 
// 0 <= removable.length < s.length 
// 0 <= removable[i] < s.length 
// p 是 s 的一个 子字符串 
// s 和 p 都由小写英文字母组成 
// removable 中的元素 互不相同 
// 
// Related Topics 数组 字符串 二分查找 
// 👍 22 👎 0


package cn.db117.leetcode.solution18;

/**
 * 1898.可移除字符的最大数目.maximum-number-of-removable-characters
 *
 * @author db117
 * @since 2021-07-26 18:11:40
 **/

public class Solution_1898 {
    public static void main(String[] args) {
        Solution solution = new Solution_1898().new Solution();

        System.out.println(solution.maximumRemovals("abcacb", "ab", new int[]{3, 1, 0}));
        System.out.println(solution.maximumRemovals("abcbddddd", "abcd", new int[]{3, 2, 1, 4, 5, 6}));
        System.out.println(solution.maximumRemovals("abcab", "abc", new int[]{0, 1, 2, 3, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumRemovals(String s, String p, int[] removable) {
            char[] pc = p.toCharArray();

            int left = 0, right = removable.length;

            while (left < right) {
                // 往大了找，选择有边界
                int mid = left + (right - left + 1) / 2;

                if (check(s.toCharArray(), pc, removable, mid)) {
                    // 继续尝试往大了找
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return right;
        }

        private boolean check(char[] sc, char[] pc, int[] removable, int k) {
            for (int i = 0; i < k; i++) {
                sc[removable[i]] = 0;
            }

            int i = 0;
            for (char c : pc) {
                while (i < sc.length && (sc[i] == 0 || sc[i] != c)) {
                    i++;
                }
                if (i >= sc.length) {
                    // s 走完了，p 还没有走完
                    return false;
                }
                i++;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}