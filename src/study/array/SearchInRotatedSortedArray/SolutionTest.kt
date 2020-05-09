package study.array.SearchInRotatedSortedArray

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun search() {
        helper(
                intArrayOf(0, 1, 2), 1, 1
        )



        helper(
                intArrayOf(4, 5, 6, 7, 0, 1, 2), 0, 4
        )

    }

    @Test
    fun search_case1() {
        helper(
                intArrayOf(4, 5, 6, 1, 3, 2), 1, 3
        )
    }

    @Test
    fun search_case2() {
        helper(
                intArrayOf(1, 3), 3, 1
        )
    }

    fun helper(intArray: IntArray, key: Int, expected: Int) {
        val result = Solution().search(intArray, key)
        assertEquals(expected, result)
    }
}