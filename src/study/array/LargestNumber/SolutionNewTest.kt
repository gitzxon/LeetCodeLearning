package study.array.LargestNumber

import org.junit.Test

import org.junit.Assert.*

class SolutionNewTest {

    @Test
    fun largestNumber() {
        assertEquals(
                "210",
                SolutionNew().largestNumber(intArrayOf(10, 2))
        )

    }
}