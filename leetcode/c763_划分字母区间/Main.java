package c763_划分字母区间;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static List<Integer> partitionLabels(String s) {
    int[] lastPositions = new int[26];
    for (int i = 0; i < s.length(); i++) {
      lastPositions[s.charAt(i) - 'a'] = i;
    }
    List<Integer> ans = new ArrayList<>();
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      end = Math.max(end, lastPositions[s.charAt(i) - 'a']);
      if (i == end) {
        ans.add(end - start + 1);
        start = end + 1;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    partitionLabels("caedbdedda");
  }
}
