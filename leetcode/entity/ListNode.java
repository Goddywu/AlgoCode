package entity;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode ofIntArray(int... intArray) {
        ListNode previous = null;
        for (int i = intArray.length - 1; i >= 0; i--) {
            previous = new ListNode(intArray[i], previous);
        }
        return previous;
    }
    
    public void print() {
        int idx = 0;
        ListNode cur = this;
        while (cur != null) {
            if (idx != 0) {
                System.out.print(" ");
            }
            System.out.print(cur.val);
            cur = cur.next;
            idx++;
        }
        System.out.println();
    }
}
