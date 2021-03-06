package cn.db117.leetcode.solution2;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 279. 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/31/031
 **/
public class Solution279 {
    public static void main(String[] args) {
        System.out.println(new Solution279().numSquares(12));
    }

    // 动态规划
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            // 每一个数字的最大值为其本身
            dp[i] = i;
        }

        // 第一个数为一不需要计算
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                // i-j*j 为减去平方数后需要几个数字
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    // 广度优先
    public int numSquares1(int n) {
        if (n < 4) {
            return n;
        }
        // 缓存
        Set<Integer> set = new HashSet<>();
        // 队列
        Deque<Integer> deque = new LinkedList<>();
        deque.push(n);
        // 次数
        int count = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Integer last = deque.pollLast();

                for (int j = 1; j <= last; j++) {

                    int temp = last - j * j;
                    // 小于0说明,已经到最大平方数了
                    if (temp < 0) {
                        break;
                    }

                    if (temp == 0) {
                        return count;
                    }

                    // 没有算过
                    if (!set.contains(temp)) {
                        deque.push(temp);
                        set.add(temp);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
