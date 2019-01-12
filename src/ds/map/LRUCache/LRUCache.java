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
    LinkedHashMap<Integer, Integer> mLinkedHashMap;

    public LRUCache(int capacity) {
        this.mCapacity = capacity;
        mLinkedHashMap = new LinkedHashMap<Integer, Integer>(capacity, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return (this.size() > mCapacity);
            }
        };
    }

    public int get(int key) {
        if (mLinkedHashMap.containsKey(key)) {
            return mLinkedHashMap.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        mLinkedHashMap.put(key, value);
    }
}

