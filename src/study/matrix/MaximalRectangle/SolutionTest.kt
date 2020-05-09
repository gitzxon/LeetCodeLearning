package study.matrix.MaximalRectangle

import org.junit.Test
import study.util.DataUtil
import kotlin.test.assertEquals

class SolutionTest {

    @Test
    fun maximalRectangle() {
        val matrix = DataUtil().parseMatrix("""
                    [
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
    """.trimIndent(), 5)
                .map { strArray ->
                    strArray.map { it[1] }.toCharArray()
                }.toTypedArray()
        val maxArea = Solution().maximalRectangle(matrix)
        assertEquals(6, maxArea)

    }

    @Test
    fun oneLine() {
        val matrix = DataUtil().parseMatrix("""
[["1","0"]]
    """.trimIndent(), 2)
                .map { strArray ->
                    strArray.map { it[1] }.toCharArray()
                }.toTypedArray()
        val maxArea = Solution().maximalRectangle(matrix)
        assertEquals(1, maxArea)
    }
}