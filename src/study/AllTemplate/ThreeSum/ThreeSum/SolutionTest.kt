package study.AllTemplate.ThreeSum.ThreeSum

import study.AllTemplate.ThreeSum.ThreeSum.slow.Solution
import org.junit.Test

class SolutionTest {

    @Test
    fun threeSum() {
        val r = Solution().threeSum(
                intArrayOf(-1, 0, 1, 2, -1, -4)
        )
        for (mutableList in r) {
            println(mutableList)
        }
    }
}