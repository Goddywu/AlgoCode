package c1_1000.c88_合并两个有序数组;

public class Main {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    if (n == 0) return;

    int p1 = m - 1;
    int p2 = n - 1;
    int counter = nums1.length - 1;
    while (p1 >= 0 && p2 >= 0) {
      if (nums1[p1] >= nums2[p2]) {
        nums1[counter--] = nums1[p1--];
      } else {
        nums1[counter--] = nums2[p2--];
      }
    }
    while (p1 >= 0) nums1[counter--] = nums1[p1--];
    while (p2 >= 0) nums1[counter--] = nums2[p2--];
  }
}
