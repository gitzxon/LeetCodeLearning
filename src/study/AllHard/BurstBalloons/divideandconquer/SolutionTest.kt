package study.AllHard.BurstBalloons.divideandconquer

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun maxCoins() {
        val result = Solution().maxCoins(
                intArrayOf(3,1,5,8)
        )
        assertEquals(167, result)
    }
}