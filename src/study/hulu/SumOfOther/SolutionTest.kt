package study.hulu.SumOfOther

import org.junit.Test
import java.util.*

class SolutionTest {
    @Test
    fun calculate() {
        Arrays.deepEquals(
                arrayOf(6, 2, 0, 11),
                Solution().calculate(
                        intArrayOf(5, 4, 2, 9)
                ).toTypedArray()
        )
    }

    @Test
    fun test1() {
        Arrays.deepEquals(
                arrayOf(14, 2, 2, 2, 0, 19),
                Solution().calculate(
                        intArrayOf(5, 4, 4, 4, 2, 9)
                ).toTypedArray()
        )
    }
}