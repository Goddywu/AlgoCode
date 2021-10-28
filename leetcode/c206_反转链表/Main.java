package c206_反转链表;

import entity.ListNode;

public class Main {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = head;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = prev;
            prev = next;
            next = tmp;
        }
        return prev;
    }
}
