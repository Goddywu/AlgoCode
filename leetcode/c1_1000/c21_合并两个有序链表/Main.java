package c1_1000.c21_合并两个有序链表;

import entity.ListNode;

public class Main {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        if (l1 == null) cur.next = l2;
        else cur.next = l1;
        return dummy.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy;
        if (l1.val <= l2.val) {
            dummy = l1;
            l1.next = mergeTwoLists(l1.next, l2);
        } else {
            dummy = l2;
            l2.next = mergeTwoLists(l1, l2.next);
        }
        return dummy;
    }
}
