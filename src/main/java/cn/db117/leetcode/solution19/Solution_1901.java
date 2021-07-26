//一个 2D 网格中的 顶峰元素 是指那些 严格大于 其相邻格子(上、下、左、右)的元素。
//
// 给你一个 从 0 开始编号 的 m x n 矩阵 mat ，其中任意两个相邻格子的值都 不相同 。找出 任意一个 顶峰元素 mat[i][j] 并 返回其
//位置 [i,j] 。 
//
// 你可以假设整个矩阵周边环绕着一圈值为 -1 的格子。 
//
// 要求必须写出时间复杂度为 O(m log(n)) 或 O(n log(m)) 的算法 
//
// 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: mat = [[1,4],[3,2]]
//输出: [0,1]
//解释: 3和4都是顶峰元素，所以[1,0]和[0,1]都是可接受的答案。
// 
//
// 示例 2: 
//
// 
//
// 
//输入: mat = [[10,20,15],[21,30,14],[7,16,32]]
//输出: [1,1]
//解释: 30和32都是顶峰元素，所以[1,1]和[2,2]都是可接受的答案。
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 500 
// 1 <= mat[i][j] <= 105 
// 任意两个相邻元素均不相等. 
// 
// Related Topics 数组 二分查找 分治 矩阵 
// 👍 4 👎 0


package cn.db117.leetcode.solution19;

import cn.db117.leetcode.base.Optimized;

import java.util.Arrays;

/**
 * 1901.找出顶峰元素 II.find-a-peak-element-ii
 *
 * @author db117
 * @since 2021-07-26 18:36:24
 **/
@Optimized
public class Solution_1901 {
    public static void main(String[] args) {
        Solution solution = new Solution_1901().new Solution();
        System.out.println(Arrays.toString(solution.findPeakGrid(new int[][]{
                {1, 2, 6},
                {3, 4, 5}
        })));// 0,2
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findPeakGrid(int[][] mat) {
            // O(m*n) 不符合题意

            int m = mat.length;
            int n = mat[0].length;
            // 旋转向上
            int i = 0, j = 0;
            while (true) {
                int cur = mat[i][j];
                if (i + 1 < m && mat[i + 1][j] > cur) {
                    i++;
                    continue;
                }
                if (j + 1 < n && mat[i][j + 1] > cur) {
                    j++;
                    continue;
                }
                if (i - 1 >= 0 && mat[i - 1][j] > cur) {
                    i--;
                    continue;
                }
                if (j - 1 >= 0 && mat[i][j - 1] > cur) {
                    j--;
                    continue;
                }
                // 到这来说明 4 个方向都比当前值大
                break;
            }

            return new int[]{i, j};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}