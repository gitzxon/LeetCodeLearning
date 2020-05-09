package study.dp.PartitionEqualSubsetSum

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class SolutionTest {

    @Test
    fun canPartition() {
        assertTrue(Solution().canPartition(intArrayOf(1, 5, 11, 5)))

        assertTrue(
                SolutionNew().Solution().canPartition(intArrayOf(1, 5, 11, 5))
        )
    }

    @Test
    fun canPartition_1() {
        assertFalse(Solution().canPartition(intArrayOf(1,2,3,5)))
        assertFalse(
                SolutionNew().Solution().canPartition(intArrayOf(1,2,3,5))
        )
    }
}