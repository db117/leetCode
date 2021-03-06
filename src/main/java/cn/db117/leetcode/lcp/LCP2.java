package cn.db117.leetcode.lcp;


import java.util.Arrays;

/**
 * LCP 2. 分式化简
 * 有一个同学在学习分式。他需要将一个连分数化成最简分数，你能帮助他吗？
 * <p>
 * <p>
 * <p>
 * 连分数是形如上图的分式。在本题中，所有系数都是大于等于0的整数。
 * <p>
 *  
 * <p>
 * 输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，且n, m最大公约数为1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：cont = [3, 2, 0, 2]
 * 输出：[13, 4]
 * 解释：原连分数等价于3 + (1 / (2 + (1 / (0 + 1 / 2))))。注意[26, 8], [-13, -4]都不是正确答案。
 * 示例 2：
 * <p>
 * 输入：cont = [0, 0, 3]
 * 输出：[3, 1]
 * 解释：如果答案是整数，令分母为1即可。
 * 限制：
 * <p>
 * cont[i] >= 0
 * 1 <= cont的长度 <= 10
 * cont最后一个元素不等于0
 * 答案的n, m的取值都能被32位int整型存下（即不超过2 ^ 31 - 1）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/deep-dark-fraction
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2020/1/5/005 18:42
 */
public class LCP2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LCP2().fraction(new int[]{
                2147483647
        })));
    }

    public int[] fraction(int[] cont) {
        int index = cont.length - 1;
        if (index == 0) {
            return new int[]{1, cont[0]};
        }
        // 分子,分母
        int top = 1, down = cont[index--];
        while (index > 0) {
            int temp = down;
            // 1除以一个分数,则交换分子分母
            down = top + down * cont[index--];
            top = temp;
        }
        // 最后一个数字,不交换分子分母
        top = top + down * cont[index];
        // 最大公约数
        int helper = helper(top, down);
        return new int[]{top / helper, down / helper};
    }

    public int helper(int a, int b) {
        if (b == 0) {
            return a;
        }
        return helper(b, a % b);
    }

}
