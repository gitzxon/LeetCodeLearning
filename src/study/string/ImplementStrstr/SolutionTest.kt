package study.string.ImplementStrstr

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun strStr() {

        assertEquals(
                2, Solution().strStr("hello", "ll")
        )

        assertEquals(
                -1,
                Solution().strStr("aaaaa","bba")
        )


    }
}