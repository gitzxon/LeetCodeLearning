package study.dp.DecodeWays

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun numDecodings() {
        helper("12", 2)
        helper("226", 3)
        helper("10", 1)
    }

    fun helper(numStr: String, expected: Int) {
        assertEquals(
                expected,
                Solution().numDecodings(numStr)
        )
    }

}