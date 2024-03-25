package c1_1000.c234_回文链表;

import entity.ListNode;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public boolean isPalindrome(ListNode head) {
    List<Integer> nums = new ArrayList<>();

    ListNode currentNode = head;
    while (currentNode != null) {
      nums.add(currentNode.val);
      currentNode = currentNode.next;
    }

    int left = 0, right = nums.size() - 1;
    while (left < right) {
      if (!nums.get(left).equals(nums.get(right))) return false;
      left++;
      right--;
    }
    return true;
  }
}
