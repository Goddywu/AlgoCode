package j6_从尾到头打印链表;

import entity.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        list.add(head.val);
        while (head.next != null) {
            head = head.next;
            list.add(head.val);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[list.size() - 1 - i] = list.get(i);
        }
        return ans;
    }

    public static int[] reversePrint2(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        int len = stack.size();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode n3 = new ListNode(2);
        ListNode n2 = new ListNode(3, n3);
        ListNode n1 = new ListNode(1, n2);
        reversePrint2(n1);
    }
}
