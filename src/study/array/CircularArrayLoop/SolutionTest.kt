package study.array.CircularArrayLoop

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun circularArrayLoop() {
        assertEquals(
                true,
                Solution().circularArrayLoop(intArrayOf(2, -1, 1, 2, 2))
        )

        assertEquals(
                false,
                Solution().circularArrayLoop(intArrayOf(-1, 2))
        )
    }
}