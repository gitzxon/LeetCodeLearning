package study.array.TopKIncreasingArray

import org.junit.Test

class SolutionTest {
    @Test
    fun topKIncreasing() {
        val ret = Solution().topKIncreasing(intArrayOf(2, 1, 4, 5, 8, 3, 7, 10, 2, 5), 2)
        // [1,4,5,8],[3,7,10]

        println("ret = ${ret}")
    }
}