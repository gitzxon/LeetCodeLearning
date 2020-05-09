package study.dp.RangeSumQuery2D

import org.junit.Test

class NumMatrixTest {

    @Test
    fun sumRegion() {

        val matrix = arrayOf(
                intArrayOf(-4, -5)
        )
        val numMatrix = NumMatrix(matrix)
        numMatrix.sumRegion(0, 0, 0, 0)
        numMatrix.sumRegion(0, 0, 0, 1)
        numMatrix.sumRegion(0, 1, 0, 1)
    }
}