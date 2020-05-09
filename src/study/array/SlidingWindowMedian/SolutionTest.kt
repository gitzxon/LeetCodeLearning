package study.array.SlidingWindowMedian

import org.junit.Test
import java.util.*
import kotlin.test.assertTrue

class SolutionTest {

    @Test
    fun medianSlidingWindow() {
        val result = Solution().medianSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3)
        println("result = ${Arrays.toString(result)}")
        assertTrue(
                doubleArrayEquals(
                        doubleArrayOf(1.0, -1.0, -1.0, 3.0, 5.0, 6.0),
                        result
                )
        )
    }

    private fun doubleArrayEquals(
            expected: DoubleArray,
            actual: DoubleArray
    ): Boolean {
        if (expected.size != actual.size) {
            return false
        }

        expected.forEachIndexed { index, d ->
            if (d - actual[index] > 0.0000000000000001) {
                return false
            }
        }

        return true
    }
}