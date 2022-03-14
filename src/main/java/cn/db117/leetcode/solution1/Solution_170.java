

//设计一个接收整数流的数据结构，该数据结构支持检查是否存在两数之和等于特定值。 
//
// 实现 TwoSum 类： 
//
// 
// TwoSum() 使用空数组初始化 TwoSum 对象 
// void add(int number) 向数据结构添加一个数 number 
// boolean find(int value) 寻找数据结构中是否存在一对整数，使得两数之和与给定的值相等。如果存在，返回 true ；否则，返回 
//false 。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["TwoSum", "add", "add", "add", "find", "find"]
//[[], [1], [3], [5], [4], [7]]
//输出：
//[null, null, null, null, true, false]
//
//解释：
//TwoSum twoSum = new TwoSum();
//twoSum.add(1);   // [] --> [1]
//twoSum.add(3);   // [1] --> [1,3]
//twoSum.add(5);   // [1,3] --> [1,3,5]
//twoSum.find(4);  // 1 + 3 = 4，返回 true
//twoSum.find(7);  // 没有两个整数加起来等于 7 ，返回 false 
//
// 
//
// 提示： 
//
// 
// -10⁵ <= number <= 10⁵ 
// -2³¹ <= value <= 2³¹ - 1 
// 最多调用 10⁴ 次 add 和 find 
// 
// Related Topics 设计 数组 哈希表 双指针 数据流 👍 67 👎 0


package cn.db117.leetcode.solution1;

import java.util.HashSet;
import java.util.Set;

/**
 * 170.两数之和 III - 数据结构设计.two-sum-iii-data-structure-design
 *
 * @author db117
 * @since 2022-03-14 11:04:29
 **/

public class Solution_170 {
    public static void main(String[] args) {
        TwoSum solution = new Solution_170().new TwoSum();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class TwoSum {
        Set<Integer> num = new HashSet<>();
        Set<Integer> sum = new HashSet<>();

        public TwoSum() {

        }

        public void add(int number) {
            for (Integer n : num) {
                sum.add(number + n);
            }
            num.add(number);
        }

        public boolean find(int value) {
            return sum.contains(value);
        }
    }

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}