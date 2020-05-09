package study.array.MaximumSubarray

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun maxSubArray() {
        assertEquals(
                6,
                Solution().maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4))
        )

    }
}