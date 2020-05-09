package study.dp.EditDistance

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun minDistance() {
        assertEquals(
                3,
                Solution().minDistance(
                        "horse",
                        "ros"
                )
        )
    }

    @Test
    fun test1() {
        assertEquals(
                5,
                Solution().minDistance(
                        "intention",
                        "execution"
                )
        )
    }
}