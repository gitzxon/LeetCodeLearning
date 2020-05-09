package study.dp.JumpGame

import org.junit.Assert.*
import org.junit.Test

class SolutionTest {

    @Test
    fun canJump() {
        assertEquals(
                true,
                Solution().canJump(intArrayOf(2,3,1,1,4))
        )
        assertEquals(
                false,
                Solution().canJump(intArrayOf(3,2,1,0,4))
        )
    }

}