package study.array.SubarraySumEqualsToK

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun subarraySum() {

        assertEquals(
                2,
                Solution().subarraySum(intArrayOf(1, 1, 1), 2)
        )
    }


    @Test
    fun test1() {
        assertEquals(
                2,
                Solution().subarraySum(intArrayOf(1, 2, 3), 3)
        )
    }
}