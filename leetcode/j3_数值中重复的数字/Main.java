package j3_数值中重复的数字;

import java.util.HashSet;

public class Main {
  public int findRepeatNumber(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for (int n : nums) {
      if (set.contains(n)) return n;
      set.add(n);
    }
    return -1;
  }
}
