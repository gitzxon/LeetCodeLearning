package study.array.NumberOfLongestIncreasingSubsequence

import org.junit.Test

class SolutionTest {
    @Test
    fun findNumberOfLIS() {
        val ret = Solution().findNumberOfLIS(
                intArrayOf(2, 2, 2, 2, 2)
        )

        println("ret = ${ret}")
    }

    @Test
    fun test1() {
        val ret = Solution().findNumberOfLIS(
                intArrayOf(1,3,5,4,7)
        )
        println("ret = ${ret}")
        assert(ret == 2)

    }

    @Test
    fun test2() {
        val ret = Solution().findNumberOfLIS(intArrayOf(1,2,4,3,5,4,7,2))
        println("ret = ${ret}")
        assert(ret == 3)
        
    }
}