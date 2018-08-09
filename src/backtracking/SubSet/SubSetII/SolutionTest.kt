package backtracking.SubSet.SubSetII

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun subsetsWithDup() {
        val result = Solution().subsetsWithDup(intArrayOf(1,2,2))
        result.forEach { print(it) }
        assertEquals(
                6,
                result.size
        )
    }
}