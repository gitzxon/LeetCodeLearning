package study.num.FindMissingNumber

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun missingNumber() {
        assertEquals(
                2,
                Solution().missingNumber(intArrayOf(3, 0, 1))
        )

        assertEquals(
                8,
                Solution().missingNumber(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1))
        )
    }
}