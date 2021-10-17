package c1_1000.c143_重排链表;

import entity.ListNode;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void reorderList(ListNode head) {
    List<ListNode> list = new ArrayList<>();
    while (head != null) {
      list.add(head);
      head = head.next;
    }
    int l = 0, r = list.size() - 1;
    while (l < r) {
      list.get(l).next = list.get(r);
      l++;
      if (l == r) break;
      list.get(r).next = list.get(l);
      r--;
    }
    list.get(l).next = null;
  }
}
