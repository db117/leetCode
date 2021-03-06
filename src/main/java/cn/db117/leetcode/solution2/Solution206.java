package cn.db117.leetcode.solution2;

import cn.db117.leetcode.util.ListNode;
import cn.db117.leetcode.util.ListNodeUtil;

/**
 * 206. 反转链表
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/17
 **/

public class Solution206 {
    public static void main(String[] args) {
        ListNode builder = ListNodeUtil.builder(new int[]{1, 2, 3, 4, 5});
        ListNodeUtil.print(new Solution206().reverseList(builder));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head, cur = head.next, last;
        while (cur != null) {
            // 指针翻转
            last = cur.next;
            cur.next = pre;
            pre = cur;
            cur = last;
        }
        // 头下一个置空
        head.next = null;
        return pre;
    }
}
