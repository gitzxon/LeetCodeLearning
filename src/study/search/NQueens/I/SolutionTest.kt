package study.search.NQueens.I

import org.junit.Test

class SolutionTest {

    @Test
    fun solveNQueens() {
        val result = Solution().solveNQueens(4)
        result.forEach { println("it = ${it}") }
    }
}