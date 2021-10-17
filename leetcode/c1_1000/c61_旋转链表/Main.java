package c1_1000.c61_旋转链表;

import entity.ListNode;

public class Main {

    // === 1. 快慢指针空间复杂度太高

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        if (k <= 0) return head;
        ListNode quick = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            if (quick.next == null) {
                quick = head;
            } else {
                quick = quick.next;
            }
        }
        if (quick == head) return head;
        while (quick.next != null) {
            quick = quick.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        quick.next = head;
        return newHead;
    }

}
