package c25_k个一组翻转链表;

import entity.ListNode;

import java.util.Stack;

// https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
public class Main {
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        int nk = k;
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (nk > 0) {
            stack.add(cur);
            cur = cur.next;
        }
        // FIXME:
        return null;
    }
}
