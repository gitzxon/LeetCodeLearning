package study.string.kmp

import org.junit.Test

import org.junit.Assert.*
import java.util.*

class SolutionTest {

    @Test
    fun getLps() {
        test(
                intArrayOf(0, 0, 0, 0, 0),
                "abcbc"
        )

        test(
                intArrayOf(0, 0, 0, 1, 2, 0),
                "abcabd"
        )

        test(
                intArrayOf(0, 1, 2, 3, 4),
                "aaaaa"
        )

        test(
                intArrayOf(0, 0, 1, 2, 0, 1, 2),
                "ababbab"
        )


    }

    fun test(expected: IntArray, pattern: String) {
        test(expected, Solution().getLps(pattern))
        test(expected, Review().getLps(pattern))

        val next = Solution().getNextArray(pattern)
        println(Arrays.toString(next))

        test(expected = next, actual = Review().getNextArray(pattern))
    }

    fun test(expected: IntArray, actual: IntArray) {

        assertArrayEquals(expected, actual)
    }
}