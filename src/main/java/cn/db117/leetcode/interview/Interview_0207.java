


//给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个
//节点是同一节点（引用完全相同），则这两个链表相交。 示例 1： 输入：intersectVal = 8, listA = [4,1,8,4,5], listB 
//= [5,0,1,8,4,5], skipA = 2, skipB = 3 输出：Reference of the node with value = 8 输入
//解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4
//,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。 示例 2： 输入：intersectVal = 2, listA = [0
//,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1 输出：Reference of the node with v
//alue = 2 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为
// [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。 示例 3： 输入：intersectVal = 0, listA
// = [2,6,4], listB = [1,5], skipA = 3, skipB = 2 输出：null 输入解释：从各自的表头开始算起，链表 A 为 [
//2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。 解释：
//这两个链表不相交，因此返回 null。 注意： 如果两个链表没有交点，返回 null 。 在返回结果后，两个链表仍须保持原有的结构。 可假定整个链表结构中没有循
//环。 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 Related Topics 链表 
// 👍 46 👎 0


package cn.db117.leetcode.interview;

import cn.db117.leetcode.util.ListNode;

/**
 * 面试题 02.07.链表相交.intersection-of-two-linked-lists-lcci
 *
 * @author db117
 * @since 2021-01-08 15:41:19
 **/

public class Interview_0207 {
    public static void main(String[] args) {
        Solution solution = new Interview_0207().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode a = headA, b = headB;

            // 如果相交,则一定在相交点相遇(最多走a.length+b.length,如果相交则从后面开始看肯定是用一个对象)
            // 如果不相交则都会为null(同时走了a.length+b.length)

            while (a != b) {
                if (a == null) {
                    a = headB;
                } else {
                    a = a.next;
                }
                if (b == null) {
                    b = headA;
                } else {
                    b = b.next;
                }
            }

            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}