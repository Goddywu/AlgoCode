package c554_砖墙;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  /**
   * ⚠️超出内存限制了
   */
  public static int leastBricks(List<List<Integer>> wall) {
    int sum = wall.get(0).stream().reduce((a, b) -> a + b).get();
    int[] passCounts = new int[sum];
    for (List<Integer> nums : wall) {
      int count = 0;
      for (int j = 0; j < nums.size() - 1; j++) {
        count += nums.get(j);
        passCounts[count]++;
      }
    }
    int max = 0;
    for (int i = 1; i < sum; i++) {
      max = Math.max(max, passCounts[i]);
    }
    return wall.size() - max;
  }

  /**
   *
   */
  public static int leastBricks2(List<List<Integer>> wall) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < wall.size(); i++) {
      List<Integer> nums = wall.get(i);
      int sum = 0;
      for (int j = 0; j < nums.size() - 1; j++) {
        sum += nums.get(j);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
      }
    }
    int max = 0;
    for (Map.Entry<Integer, Integer> kv : map.entrySet()) {
      max = Math.max(max, kv.getValue());
    }
    return wall.size() - max;
  }

  public static void main(String[] args) {
//    List<List<Integer>> wall = new ArrayList<>();
//    wall.add(Arrays.asList(1,2,2,1));
//    wall.add(Arrays.asList(3,1,2));
//    wall.add(Arrays.asList(1,3,2));
//    wall.add(Arrays.asList(2,4));
//    wall.add(Arrays.asList(3,1,2));
//    wall.add(Arrays.asList(1,3,1,1));
//    leastBricks(wall);

    List<List<Integer>> wall = new ArrayList<>();
    wall.add(Arrays.asList(1,1));
    wall.add(Arrays.asList(2));
    wall.add(Arrays.asList(1,1));
    leastBricks2(wall);
  }
}
