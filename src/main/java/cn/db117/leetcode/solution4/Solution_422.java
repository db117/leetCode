

//给你一个单词序列，判断其是否形成了一个有效的单词方块。 
//
// 有效的单词方块是指此由单词序列组成的文字方块的 第 k 行 和 第 k 列 (0 ≤ k < max(行数, 列数)) 所显示的字符串完全相同。 
//
// 注意： 
//
// 
// 给定的单词数大于等于 1 且不超过 500。 
// 单词长度大于等于 1 且不超过 500。 
// 每个单词只包含小写英文字母 a-z。 
// 
//
// 
//
// 示例 1： 
//
// 输入：
//[
//  "abcd",
//  "bnrt",
//  "crmy",
//  "dtye"
//]
//
//输出：
//true
//
//解释：
//第 1 行和第 1 列都是 "abcd"。
//第 2 行和第 2 列都是 "bnrt"。
//第 3 行和第 3 列都是 "crmy"。
//第 4 行和第 4 列都是 "dtye"。
//
//因此，这是一个有效的单词方块。
// 
//
// 
//
// 示例 2： 
//
// 输入：
//[
//  "abcd",
//  "bnrt",
//  "crm",
//  "dt"
//]
//
//输出：
//true
//
//解释：
//第 1 行和第 1 列都是 "abcd"。
//第 2 行和第 2 列都是 "bnrt"。
//第 3 行和第 3 列都是 "crm"。
//第 4 行和第 4 列都是 "dt"。
//
//因此，这是一个有效的单词方块。
// 
//
// 
//
// 示例 3： 
//
// 输入：
//[
//  "ball",
//  "area",
//  "read",
//  "lady"
//]
//
//输出：
//false
//
//解释：
//第 3 行是 "read" ，然而第 3 列是 "lead"。
//
//因此，这 不是 一个有效的单词方块。
// 
//
// 
// Related Topics 数组 矩阵 👍 31 👎 0


package cn.db117.leetcode.solution4;

import java.util.ArrayList;
import java.util.List;

/**
 * 422.有效的单词方块.valid-word-square
 *
 * @author db117
 * @since 2022-03-28 11:19:54
 **/

public class Solution_422 {
    public static void main(String[] args) {
        Solution solution = new Solution_422().new Solution();
        List<String> words = new ArrayList<>();
        words.add("ball");
        words.add("asee");
        words.add("let");
        words.add("lep");
        // ["ball","asee","let","lep"]

        System.out.println(solution.validWordSquare(words));

        words.clear();
        // ["abc","bde","cefg"]
        words.add("abc");
        words.add("bde");
        words.add("cefg");
        System.out.println(solution.validWordSquare(words));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validWordSquare(List<String> words) {
            int len = words.size();
            if (words.get(0).length() != len) {
                return false;
            }

            for (int i = 0; i < words.size(); i++) {
                char[] chars = words.get(i).toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    if (words.size() <= j) {
                        // 越界
                        return false;
                    }
                    String s = words.get(j);
                    if (s.length() <= i) {
                        // 越界
                        return false;
                    }
                    if (s.charAt(i) != chars[j]) {
                        return false;
                    }
                }

            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}