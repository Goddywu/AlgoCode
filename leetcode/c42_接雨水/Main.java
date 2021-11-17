package c42_接雨水;

public class Main {

  public int trap(int[] height) {
    int len = height.length;
    int[] l = new int[len];
    int max = 0;
    for (int i = 0; i < len; i++) {
      max = Math.max(max, height[i]);
      l[i] = max;
    }
    int[] r = new int[len];
    max = 0;
    for (int i = len - 1; i >= 0; i--) {
      max = Math.max(max, height[i]);
      r[i] = max;
    }
    int result = 0;
    for (int i = 0; i < len; i++) {
      result += Math.min(l[i], r[i]) - height[i];
    }
    return result;
  }
}
