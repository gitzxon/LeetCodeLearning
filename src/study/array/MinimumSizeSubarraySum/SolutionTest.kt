package study.array.MinimumSizeSubarraySum

import org.junit.Test

class SolutionTest {
    @Test
    fun minimumSize() {
        val ret = Solution().minimumSize(intArrayOf(2, 3, 1, 2, 4, 3), 7)
        println("ret = ${ret}")
    }

    @Test
    fun test1() {
        val ret = Solution().minimumSize(intArrayOf(1, 2, 3, 4, 5), 100)
        println("ret = ${ret}")
    }
}