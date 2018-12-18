package pattern.ThreeSum.ThreeSum

import org.junit.Test
import pattern.ThreeSum.ThreeSum.slow.Solution

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