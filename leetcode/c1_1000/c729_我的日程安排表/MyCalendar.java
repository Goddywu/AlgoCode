package c1_1000.c729_我的日程安排表;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {

    List<int[]> times;

    public MyCalendar() {
        times = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] time : times) {
            if (!(start >= time[1] || end <= time[0])) return false;
        }
        times.add(new int[] {start, end});
        return true;
    }
}
