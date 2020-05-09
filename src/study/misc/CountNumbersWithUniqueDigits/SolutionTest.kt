package study.misc.CountNumbersWithUniqueDigits

import org.junit.Assert.*

class SolutionTest {

    @org.junit.Test
    fun countNumbersWithUniqueDigits() {

        assertEquals(91, Solution().countNumbersWithUniqueDigits(2))
        assertEquals(739, Solution().countNumbersWithUniqueDigits(3))
    }
}