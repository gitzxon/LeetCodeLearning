package study.dp.MaximumSquare

import org.junit.Test

class SolutionTest {

    @Test
    fun maximalSquare() {
        val matrix = arrayOf(
                charArrayOf('1', '0', '1', '0', '0'),
                charArrayOf('1', '0', '1', '1', '1'),
                charArrayOf('1', '1', '1', '1', '1'),
                charArrayOf('1', '0', '0', '1', '0')
        )

        val result = Solution().maximalSquare(matrix)
        println("result = ${result}")

    }

    @Test
    fun test1() {
        val result = Solution().maximalSquare(
                arrayOf(
                        charArrayOf('1','1','1','1'),
                        charArrayOf('1','1','1','1'),
                        charArrayOf('1','1','1','1')
                )
        )
        println("result = ${result}")
    }
}