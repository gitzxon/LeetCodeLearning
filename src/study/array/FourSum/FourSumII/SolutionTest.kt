package study.array.FourSum.FourSumII

import org.junit.Test

class SolutionTest {

    @Test
    fun fourSumCount() {
        val result = Solution().fourSumCount(
                intArrayOf(1, 2),
                intArrayOf(-2, -1),
                intArrayOf(-1, 2),
                intArrayOf(0, 2)
        )

        println("result = ${result}")
    }
}