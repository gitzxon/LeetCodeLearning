package study.AllTemplate.ThreeSum.ThreeSum.normal

import org.junit.Test

class SolutionTest {

    @Test
    fun threeSum() {

        val list = Solution().threeSum(
                intArrayOf(-1, 0, 1, 2, -1, -4)
        )
        list.forEach {
            println("it = ${it}")
        }
    }
}