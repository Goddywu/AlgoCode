package c876_链表的中间结点;

import entity.ListNode;

public class Main {

    public ListNode middleNode(ListNode head) {
        ListNode tmp = head;
        int count = 1;
        while (tmp.next != null) {
            tmp = tmp.next;
            count++;
        }
        count /= 2;
        while (count > 0) {
            head = head.next;
            count--;
        }
        return head;
    }

    public ListNode middleNode2(ListNode head) {
        ListNode quick = new ListNode(-1, head);
        ListNode slow = quick;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
