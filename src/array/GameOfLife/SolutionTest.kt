package array.GameOfLife

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun gameOfLife() {
        val board = arrayOf(
                intArrayOf(0,1,0),
                intArrayOf(0,0,1),
                intArrayOf(1,1,1),
                intArrayOf(0,0,0)
        )
        Solution().gameOfLife(board)
    }
}