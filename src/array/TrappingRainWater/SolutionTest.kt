package array.TrappingRainWater

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun trap() {
        assertEquals(
                6,
                Solution().trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1))
        )
    }

    @Test
    fun trap_1() {
        assertEquals(
                23,
                Solution().trap(intArrayOf(5,5,1,7,1,1,5,2,7,6))
        )
    }
}