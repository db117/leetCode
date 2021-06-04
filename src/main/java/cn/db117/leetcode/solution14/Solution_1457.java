// 给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
//
// 请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：root = [2,3,1,3,1,null,1]
//输出：2 
//解释：上图为给定的二叉树。总共有 3 条从根到叶子的路径：红色路径 [2,3,3] ，绿色路径 [2,1,1] 和路径 [2,3,1] 。
//     在这些路径中，只有红色和绿色的路径是伪回文路径，因为红色路径 [2,3,3] 存在回文排列 [3,2,3] ，绿色路径 [2,1,1] 存在回文排
//列 [1,2,1] 。
// 
//
// 示例 2： 
//
// 
//
// 输入：root = [2,1,1,1,3,null,null,null,null,null,1]
//输出：1 
//解释：上图为给定二叉树。总共有 3 条从根到叶子的路径：绿色路径 [2,1,1] ，路径 [2,1,3,1] 和路径 [2,1] 。
//     这些路径中只有绿色路径是伪回文路径，因为 [2,1,1] 存在回文排列 [1,2,1] 。
// 
//
// 示例 3： 
//
// 输入：root = [9]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 给定二叉树的节点数目在 1 到 10^5 之间。 
// 节点值在 1 到 9 之间。 
// 
// Related Topics 位运算 树 深度优先搜索 
// 👍 31 👎 0


package cn.db117.leetcode.solution14;

import cn.db117.leetcode.util.TreeNode;
import cn.db117.leetcode.util.TreeNodeUtil;

/**
 * 1457.二叉树中的伪回文路径.pseudo-palindromic-paths-in-a-binary-tree
 *
 * @author db117
 * @since 2021-06-04 15:36:56
 **/

public class Solution_1457 {
    public static void main(String[] args) {
        Solution solution = new Solution_1457().new Solution();
        TreeNode node = TreeNodeUtil.build(new Integer[]{
                2, 3, 1, 3, 1, null, 1
        });

        System.out.println(solution.pseudoPalindromicPaths(node));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int pseudoPalindromicPaths(TreeNode root) {
            int[] ans = new int[1];
            dfs(root, 0, ans);
            return ans[0];
        }


        private void dfs(TreeNode root, int tmp, int[] ans) {
            if (root == null) {
                return;
            }
            // 用 9 个 bit 来保存数字出现次数 1 奇数次 0 偶数次
            tmp ^= (1 << root.val);

            if (root.left == null && root.right == null) {
                // 都出现偶数次
                // 或者只有一个 1
                if (tmp == 0 || (tmp & tmp - 1) == 0) {
                    ans[0]++;
                }
            }

            dfs(root.left, tmp, ans);
            dfs(root.right, tmp, ans);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}