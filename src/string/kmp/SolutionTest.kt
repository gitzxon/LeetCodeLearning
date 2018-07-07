package string.kmp

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun getLps() {
        assertArrayEquals(
                intArrayOf(0, 0, 0, 0, 0),
                Solution().getLps("abcbc")
        )

        assertArrayEquals(
                intArrayOf(0, 0, 0, 1, 2, 0),
                Solution().getLps("abcabd")
        )

        assertArrayEquals(
                intArrayOf(0, 1, 2, 3, 4),
                Solution().getLps("aaaaa")
        )

        assertArrayEquals(
                intArrayOf(0,0,1,2,0,1,2),
                Solution().getLps("ababbab")
        )

    }
}