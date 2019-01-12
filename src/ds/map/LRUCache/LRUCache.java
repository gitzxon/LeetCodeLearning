package ds.map.LRUCache;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 简单高效的实现。
 * 基于 LinkedHashMap
 * 添加一个 mCapacity 来控制 size。
 */
class LRUCache {

    int mCapacity;
    LinkedHashMap<Integer, Integer> linkedHashMap;
    
    public LRUCache(int capacity) {
        this.mCapacity = capacity;
        linkedHashMap = new LinkedHashMap<Integer, Integer>(capacity, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return (this.size() > mCapacity);
            }
        };
    }

    public int get(int key) {
        if (linkedHashMap.containsKey(key)) {
            return linkedHashMap.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        linkedHashMap.put(key, value);
    }
}

