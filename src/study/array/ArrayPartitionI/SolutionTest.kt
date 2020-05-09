package study.array.ArrayPartitionI

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun arrayPairSum() {
        assertEquals(
                4,
                Solution().arrayPairSum(intArrayOf(1,3,4,2))
        )
    }
}