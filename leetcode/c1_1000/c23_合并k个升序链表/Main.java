package c1_1000.c23_合并k个升序链表;

import entity.ListNode;
import java.util.PriorityQueue;

public class Main {

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) return null;
    PriorityQueue<ListNode> queue = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
    for (ListNode list : lists) {
      if (list == null) continue;
      queue.offer(list);
    }
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (!queue.isEmpty()) {
      ListNode next = queue.poll();
      cur.next = next;
      cur = cur.next;
      if (next.next != null) {
        queue.offer(next.next);
      }
    }
    return dummy.next;
  }
}
