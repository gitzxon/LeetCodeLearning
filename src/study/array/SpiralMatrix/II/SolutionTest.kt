package study.array.SpiralMatrix.II

import org.junit.Test
import java.util.*

class SolutionTest {

    @Test
    fun generateMatrix() {
        println(Arrays.deepToString(Solution().generateMatrix(4)))
        println(Arrays.deepToString(Solution().generateMatrix(3)))
    }
}