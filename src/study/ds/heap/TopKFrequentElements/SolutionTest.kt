package study.ds.heap.TopKFrequentElements

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun topKFrequent() {
        val actural = Solution().topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2).toIntArray()
        val expected = intArrayOf(1, 2)

        assertArrayEquals(
            expected, actural
        )
    }
}