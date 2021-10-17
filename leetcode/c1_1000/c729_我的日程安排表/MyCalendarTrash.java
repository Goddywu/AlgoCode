package c1_1000.c729_我的日程安排表;

import java.util.BitSet;

// https://leetcode-cn.com/problems/my-calendar-i/
// 超时
public class MyCalendarTrash {
    BitSet bitSet;

    public MyCalendarTrash() {
        bitSet = new BitSet((int) Math.pow(2, 36));
    }

    public boolean book(int start, int end) {
        if (start >= end) return false;

        boolean isBooked = false;
        for (int i = start; i < end; i++) {
            boolean booked = bitSet.get(i);
            if (booked) {
                return false;
            }
        }
        for (int i = start; i < end; i++) {
            bitSet.set(i, true);
        }
        return true;
    }
}
