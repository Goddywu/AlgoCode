package c1_1000.c146_LRU缓存机制;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Main {

  static class LRUCache extends LinkedHashMap<Integer, Integer> {

    private final int capacity;

    public LRUCache(int capacity) {
      super(capacity, 0.75f, true);
      this.capacity = capacity;
    }

    public int get(int key) {
      return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
      super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Entry<Integer, Integer> eldest) {
      return size() > capacity;
    }
  }
}
