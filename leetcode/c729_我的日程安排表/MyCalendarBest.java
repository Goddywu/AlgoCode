package c729_我的日程安排表;

import java.util.TreeMap;

public class MyCalendarBest {

    TreeMap<Integer, Integer> calendar;

    MyCalendarBest() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}
