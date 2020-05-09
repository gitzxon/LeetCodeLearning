package study.array.MaximumSubarray.dp

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {

    @Test
    fun maxSubArray() {
        assertEquals(
                6,
                Solution().maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4))
        )

    }
}