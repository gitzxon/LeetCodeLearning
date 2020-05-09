package study.ds.map.LRUCache

import org.junit.Test

class MyLRUCacheTest {

    @Test
    fun test() {
        val lruCache = MyLRUCache(2)
        println("lruCache.put(1,1) = ${lruCache.put(1,1)}")
        println("lruCache.put(2,2) = ${lruCache.put(2,2)}")
        println("lruCache.get(1) = ${lruCache.get(1)}")
        println("lruCache.put(3,3) = ${lruCache.put(3,3)}")
        println("lruCache.get(2) = ${lruCache.get(2)}")
        println("lruCache.put(4,4) = ${lruCache.put(4,4)}")
        println("lruCache.get(1) = ${lruCache.get(1)}")
        println("lruCache.get(3) = ${lruCache.get(3)}")
        println("lruCache.get(4) = ${lruCache.get(4)}")
    }

}