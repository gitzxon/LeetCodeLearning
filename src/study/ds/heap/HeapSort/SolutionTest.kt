package study.ds.heap.HeapSort

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun heapSort() {

        assertArrayEquals(
                intArrayOf(1, 2, 3),
                Solution().heapSort(intArrayOf(1, 2, 3))
        )

        assertArrayEquals(
                intArrayOf(1, 2, 3),
                Solution().heapSort(intArrayOf(3, 2, 1))
        )

        assertArrayEquals(
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
                Solution().heapSort(intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1))
        )
    }

}