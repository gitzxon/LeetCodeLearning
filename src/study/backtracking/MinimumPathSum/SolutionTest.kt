package study.backtracking.MinimumPathSum

import org.junit.Test

class SolutionTest {

    @Test
    fun minPathSum() {
        val grid = arrayOf(
                intArrayOf(1, 3, 1),
                intArrayOf(1, 5, 1),
                intArrayOf(4, 2, 1)
        )
        val min = Solution().minPathSum(grid)
        println("min = ${min}")
    }
}