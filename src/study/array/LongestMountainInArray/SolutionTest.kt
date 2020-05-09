package study.array.LongestMountainInArray

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun longestMountain() {
        assertEquals(
                5,
                Solution().longestMountain(intArrayOf(2, 1, 4, 7, 3, 2, 5))
        )

        assertEquals(
                0,
                Solution().longestMountain(intArrayOf(2, 2, 2))
        )

        assertEquals(
                5,
                SolutionNew().longestMountain(intArrayOf(2, 1, 4, 7, 3, 2, 5))
        )

        assertEquals(
                0,
                SolutionNew().longestMountain(intArrayOf(2, 2, 2))
        )
    }

    @Test
    fun test1() {
        assertEquals(
                11,
                Solution().longestMountain(intArrayOf(0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0))
        )

        assertEquals(
                11,
                SolutionNew().longestMountain(intArrayOf(0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0))
        )
    }

    @Test
    fun test2() {
        assertEquals(
                0,
                Solution().longestMountain(intArrayOf(2, 3, 3, 2, 0, 2))
        )
        assertEquals(
                0,
                SolutionNew().longestMountain(intArrayOf(2, 3, 3, 2, 0, 2))
        )
    }

    @Test
    fun  test3() {
        assertEquals(
                4,
                Solution().longestMountain(intArrayOf(875,884,239,731,723,685))
        )

        assertEquals(
                4,
                SolutionNew().longestMountain(intArrayOf(875,884,239,731,723,685))
        )
    }

}