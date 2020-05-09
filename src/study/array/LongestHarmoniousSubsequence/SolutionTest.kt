package study.array.LongestHarmoniousSubsequence

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun findLHS() {
        assertEquals(
                5,
                Solution().findLHS(intArrayOf(1,3,2,2,5,2,3,7))
        )


    }
}