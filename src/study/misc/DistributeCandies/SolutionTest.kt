package study.misc.DistributeCandies

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun distributeCandies() {
        assertEquals(
                3,
                Solution().distributeCandies(intArrayOf(1,1,2,2,3,3))
        )

        assertEquals(
                2,
                Solution().distributeCandies(intArrayOf(1,1,2,3))
        )
    }
}