

//给你两个字符串数组 words1 和 words2 ，请你返回在两个字符串数组中 都恰好出现一次 的字符串的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing",
//"leetcode","is"]
//输出：2
//解释：
//- "leetcode" 在两个数组中都恰好出现一次，计入答案。
//- "amazing" 在两个数组中都恰好出现一次，计入答案。
//- "is" 在两个数组中都出现过，但在 words1 中出现了 2 次，不计入答案。
//- "as" 在 words1 中出现了一次，但是在 words2 中没有出现过，不计入答案。
//所以，有 2 个字符串在两个数组中都恰好出现了一次。
// 
//
// 示例 2： 
//
// 
//输入：words1 = ["b","bb","bbb"], words2 = ["a","aa","aaa"]
//输出：0
//解释：没有字符串在两个数组中都恰好出现一次。
// 
//
// 示例 3： 
//
// 
//输入：words1 = ["a","ab"], words2 = ["a","a","a","ab"]
//输出：1
//解释：唯一在两个数组中都出现一次的字符串是 "ab" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words1.length, words2.length <= 1000 
// 1 <= words1[i].length, words2[j].length <= 30 
// words1[i] 和 words2[j] 都只包含小写英文字母。 
// 
// Related Topics 数组 哈希表 字符串 计数 👍 0 👎 0


package cn.db117.leetcode.solution20;

import java.util.HashMap;
import java.util.Map;

/**
 * 2085.统计出现过一次的公共字符串.count-common-words-with-one-occurrence
 *
 * @author db117
 * @since 2021-12-03 11:39:35
 **/

public class Solution_2085 {
    public static void main(String[] args) {
        Solution solution = new Solution_2085().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countWords(String[] words1, String[] words2) {
            Map<String, Integer> map1 = new HashMap<>();
            Map<String, Integer> map2 = new HashMap<>();

            for (String s : words1) {
                map1.put(s, map1.getOrDefault(s, 0) + 1);
            }
            for (String s : words2) {
                map2.put(s, map2.getOrDefault(s, 0) + 1);
            }

            int ans = 0;
            for (Map.Entry<String, Integer> entry : map1.entrySet()) {
                String s = entry.getKey();
                Integer count = entry.getValue();
                if (count != 1) {
                    continue;
                }

                Integer count2 = map2.get(s);
                if (count2 != null && count2 == 1) {
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}