package study.search.dfs.NQueensI

import org.junit.Test

class SolutionTest {
    @Test
    fun solveNQueens() {
        val result = Solution().solveNQueens(4)
        println("result.size = ${result.size}")
        println(result.joinToString(", "))
    }
}