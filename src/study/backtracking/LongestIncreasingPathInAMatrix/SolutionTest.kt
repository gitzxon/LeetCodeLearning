package study.backtracking.LongestIncreasingPathInAMatrix

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun longestIncreasingPath() {

        val result = Solution().longestIncreasingPath(
                arrayOf(
                        intArrayOf(9, 9, 4),
                        intArrayOf(6, 6, 8),
                        intArrayOf(2, 1, 1)
                )
        )
        assertEquals(
                4,
                result
        )

    }

    @Test
    fun longestIncreasingPath_1() {

        val result = Solution().longestIncreasingPath(
                arrayOf(
                        intArrayOf(3,4,5),
                        intArrayOf(3,2,6),
                        intArrayOf(2,2,1)

                )
        )
        assertEquals(
                4,
                result
        )

    }
}