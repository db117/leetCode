

//设计一个最大栈数据结构，既支持栈操作，又支持查找栈中最大元素。 
//
// 实现 MaxStack 类： 
//
// 
// MaxStack() 初始化栈对象 
// void push(int x) 将元素 x 压入栈中。 
// int pop() 移除栈顶元素并返回这个元素。 
// int top() 返回栈顶元素，无需移除。 
// int peekMax() 检索并返回栈中最大元素，无需移除。 
// int popMax() 检索并返回栈中最大元素，并将其移除。如果有多个最大元素，只要移除 最靠近栈顶 的那个。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["MaxStack", "push", "push", "push", "top", "popMax", "top", "peekMax", "pop",
// "top"]
//[[], [5], [1], [5], [], [], [], [], [], []]
//输出
//[null, null, null, null, 5, 5, 1, 5, 1, 5]
//
//解释
//MaxStack stk = new MaxStack();
//stk.push(5);   // [5] - 5 既是栈顶元素，也是最大元素
//stk.push(1);   // [5, 1] - 栈顶元素是 1，最大元素是 5
//stk.push(5);   // [5, 1, 5] - 5 既是栈顶元素，也是最大元素
//stk.top();     // 返回 5，[5, 1, 5] - 栈没有改变
//stk.popMax();  // 返回 5，[5, 1] - 栈发生改变，栈顶元素不再是最大元素
//stk.top();     // 返回 1，[5, 1] - 栈没有改变
//stk.peekMax(); // 返回 5，[5, 1] - 栈没有改变
//stk.pop();     // 返回 1，[5] - 此操作后，5 既是栈顶元素，也是最大元素
//stk.top();     // 返回 5，[5] - 栈没有改变
// 
//
// 
//
// 提示： 
//
// 
// -10⁷ <= x <= 10⁷ 
// 最多调用 10⁴ 次 push、pop、top、peekMax 和 popMax 
// 调用 pop、top、peekMax 或 popMax 时，栈中 至少存在一个元素 
// 
//
// 
//
// 进阶： 
//
// 
// 试着设计解决方案：调用 top 方法的时间复杂度为 O(1) ，调用其他方法的时间复杂度为 O(logn) 。 
// 
// Related Topics 栈 设计 链表 双向链表 有序集合 👍 102 👎 0


package cn.db117.leetcode.solution7;

import java.util.*;

/**
 * 716.最大栈.max-stack
 *
 * @author db117
 * @since 2022-04-26 17:02:52
 **/

public class Solution_716 {
    public static void main(String[] args) {
        MaxStack stk = new Solution_716().new MaxStack();

        //MaxStack stk = new MaxStack();
        stk.push(5);   // [5] - 5 既是栈顶元素，也是最大元素
        stk.push(1);   // [5, 1] - 栈顶元素是 1，最大元素是 5
        stk.push(5);   // [5, 1, 5] - 5 既是栈顶元素，也是最大元素

        System.out.println(stk.top());
        // 返回 5，[5, 1, 5] - 栈没有改变

        System.out.println(stk.popMax());
        // 返回 5，[5, 1] - 栈发生改变，栈顶元素不再是最大元素

        System.out.println(stk.top());
        // 返回 1，[5, 1] - 栈没有改变

        System.out.println(stk.peekMax());
        // 返回 5，[5, 1] - 栈没有改变

        System.out.println(stk.pop());
        // 返回 1，[5] - 此操作后，5 既是栈顶元素，也是最大元素

        System.out.println(stk.top());
        // 返回 5，[5] - 栈没有改变
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MaxStack {

        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> deque = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());


        public MaxStack() {
        }

        public void push(int x) {
            deque.offerLast(x);
            priorityQueue.add(x);
        }

        public int pop() {
            Integer ans = deque.pollLast();
            priorityQueue.remove(ans);
            return ans;
        }

        public int top() {
            return deque.peekLast();
        }

        public int peekMax() {
            return priorityQueue.peek();
        }

        public int popMax() {
            Integer ans = priorityQueue.poll();
            deque.removeLastOccurrence(ans);
            return ans;
        }


    }

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
//leetcode submit region end(Prohibit modification and deletion)

}