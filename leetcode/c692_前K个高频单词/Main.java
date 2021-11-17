package c692_前K个高频单词;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    /**
     * 方法一、优先队列
     */
//    PriorityQueue<Map.Entry<String, Integer>> queue =
//        new PriorityQueue<>(
//            (a, b) -> b.getValue() == a.getValue()
//                ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
//    for (Map.Entry<String, Integer> entry : map.entrySet()) {
//      queue.offer(entry);
//    }
//    List<String> ans = new ArrayList<>();
//    while (k-- > 0) {
//      ans.add(queue.poll().getKey());
//    }
//    return ans;

    /**
     * 方法二、list.sort
     */
    List<String> list = new ArrayList<>(map.keySet());
    list.sort((a, b) ->
        map.get(a) == map.get(b) ? a.compareTo(b) : map.get(b) - map.get(a));
    return list.subList(0, k);
  }
}
