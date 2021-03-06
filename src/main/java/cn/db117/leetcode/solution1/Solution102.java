package cn.db117.leetcode.solution1;

import cn.db117.leetcode.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 102. 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/12
 **/

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 保存下一层节点
        Deque<TreeNode> deque = new ArrayDeque<>();
        // 保存当前层数据
        List<Integer> temp = new ArrayList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            // 遍历队列,然后保存当前队列值
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                temp.add(poll.val);
                // 把下一层节点保存到队列中
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }

            res.add(new ArrayList<>(temp));
            temp.clear();
        }
        return res;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, TreeNode treeNode, int depth) {
        if (treeNode == null) {
            return;
        }
        // 当前深度大于数组长度
        if (depth > res.size() - 1) {
            res.add(new ArrayList<>());
        }
        // 添加到本层
        res.get(depth).add(treeNode.val);
        // 左
        helper(res, treeNode.left, depth + 1);
        // 右
        helper(res, treeNode.right, depth + 1);
    }
}
