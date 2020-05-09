package study.stack.DailyTemperatures

import org.junit.Test

import java.util.*

class SolutionTest {

    @Test
    fun dailyTemperatures() {
        val result = Solution().dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73))
        println(Arrays.toString(result))
    }
}