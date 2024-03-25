package c1_1000.c19_删除链表的倒数第N个结点;

import entity.ListNode;

public class Main {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode quick = dummy;
        ListNode slow = dummy;
        while (n > 0) {
            quick = quick.next;
            n--;
        }
        while (quick.next != null) {
            slow = slow.next;
            quick = quick.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
