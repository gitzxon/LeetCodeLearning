package study.dp.UniquePathBundle.UniquePathII

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun uniquePathsWithObstacles() {
        val res = Solution().uniquePathsWithObstacles(
                arrayOf(
                        intArrayOf(0,0,0),
                        intArrayOf(0,1,0),
                        intArrayOf(0,0,0)
                )
        )
        assertEquals(2, res)
    }
}