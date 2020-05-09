package study.ds.map.LRUCache;


import java.util.HashMap;


class MyLRUCache {

    private int capacity;
    private HashMap<Integer, Integer> entryHashMap;
    private HashMap<Integer, DoubleLinkedList> positionHashMap;
    private DoubleLinkedList recentlyUsedEntryListHead = null;
    private DoubleLinkedList recentlyUsedEntryListTail = null;


    public MyLRUCache(int capacity) {
        this.capacity = capacity;
        entryHashMap = new HashMap<>();
        positionHashMap = new HashMap<>();
    }

    public int get(int key) {
        int value;
        if (entryHashMap.containsKey(key)) {
            value = entryHashMap.get(key);
            DoubleLinkedList cur = positionHashMap.get(key);
            moveToHead(cur);
            return value;
        } else {
            value = -1;
        }
        return value;
    }

    public void put(int key, int value) {
        if (entryHashMap.containsKey(key)) {
            entryHashMap.put(key, value);
            moveToHead(positionHashMap.get(key));
        } else {
            entryHashMap.put(key, value);
            DoubleLinkedList doubleLinkedList = new DoubleLinkedList(key);
            positionHashMap.put(key, doubleLinkedList);
            if (recentlyUsedEntryListHead == null && recentlyUsedEntryListTail == null) {
                recentlyUsedEntryListHead = doubleLinkedList;
                recentlyUsedEntryListTail = doubleLinkedList;
            } else {
                doubleLinkedList.next = recentlyUsedEntryListHead;
                recentlyUsedEntryListHead.prev = doubleLinkedList;
                recentlyUsedEntryListHead = doubleLinkedList;
            }

            if (entryHashMap.size() > capacity) {
                removeTail();
            }
        }
    }

    private void moveToHead(DoubleLinkedList cur) {
        if (cur == recentlyUsedEntryListHead) {
            return;
        } else if (cur == recentlyUsedEntryListTail) {
            recentlyUsedEntryListTail = cur.prev;
            recentlyUsedEntryListTail.next = null;
            cur.next = recentlyUsedEntryListHead;
            recentlyUsedEntryListHead.prev = cur;
            recentlyUsedEntryListHead = cur;
        } else {
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            cur.next = recentlyUsedEntryListHead;
            recentlyUsedEntryListHead.prev = cur;
            recentlyUsedEntryListHead = cur;
        }
    }

    private void removeTail() {
        if (recentlyUsedEntryListTail == null) {
            return;
        } else {
            DoubleLinkedList cur = recentlyUsedEntryListTail;
            if (recentlyUsedEntryListHead == recentlyUsedEntryListTail) {
                recentlyUsedEntryListHead = null;
                recentlyUsedEntryListTail = null;
            } else {
                recentlyUsedEntryListTail = recentlyUsedEntryListTail.prev;
                recentlyUsedEntryListTail.next.prev = null;
                recentlyUsedEntryListTail.next = null;
            }
            entryHashMap.remove(cur.value);
            positionHashMap.remove(cur.value);
        }
    }

    class DoubleLinkedList {

        DoubleLinkedList prev;
        DoubleLinkedList next;
        int value;

        DoubleLinkedList(int value) {
            this.value = value;
        }

    }

}