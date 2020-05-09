package study.binarysearch.SearchInsertPosition

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun searchInsert() {
        val result = Solution().searchInsert(
                intArrayOf(1, 3, 5, 6), 5
        )
        assertEquals(2, result)
    }

    @Test
    fun test1() {
        val result = Solution().searchInsert(
                intArrayOf(1, 3, 5, 6), 2
        )
        assertEquals(1, result)
    }

    @Test
    fun test2() {
        val result = Solution().searchInsert(
                intArrayOf(1, 3, 5, 6), 0
        )
        assertEquals(0, result)
    }
}