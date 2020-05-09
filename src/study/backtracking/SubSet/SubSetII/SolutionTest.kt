package study.backtracking.SubSet.SubSetII

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun subsetsWithDup() {

        helper(intArrayOf(1,2,2), 6)
        helper(intArrayOf(5,5,5,5,5), 6)
    }

    fun helper(input: IntArray, expectedSize: Int) {
        val result = Solution().subsetsWithDup(input)

        result.forEach {
            print(it)
        }

        assertEquals(
                expectedSize,
                result.size
        )
    }
}