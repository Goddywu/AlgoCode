package c141_环形链表;

import entity.ListNode;
import java.util.HashSet;

public class Main {

  public boolean hasCycle(ListNode head) {
    HashSet<ListNode> set = new HashSet<>();
    while (head != null) {
      if (set.contains(head)) {
        return true;
      } else {
        set.add(head);
        head = head.next;
      }
    }
    return false;
  }

  public boolean hasCycle2(ListNode head) {
    ListNode quick = head;
    ListNode slow = new ListNode(0, head);
    while (quick != null) {
      if (quick == slow) {
        return true;
      } else if (quick.next == null) {
        return false;
      } else {
        quick = quick.next.next;
        slow = slow.next;
      }
    }
    return false;
  }
}
