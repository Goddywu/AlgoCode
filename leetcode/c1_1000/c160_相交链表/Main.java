package c1_1000.c160_相交链表;

import entity.ListNode;
import java.util.HashSet;

public class Main {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    HashSet<ListNode> set = new HashSet<>();
    ListNode tmp = headA;
    while (tmp != null) {
      set.add(tmp);
      tmp = tmp.next;
    }
    tmp = headB;
    while (tmp != null) {
      if (set.contains(tmp)) return tmp;
      tmp = tmp.next;
    }
    return null;
  }
}
