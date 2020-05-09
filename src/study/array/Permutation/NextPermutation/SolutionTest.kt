package study.array.Permutation.NextPermutation

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun nextPermutation() {
        helper(intArrayOf(1,3,2), intArrayOf(1,2,3))
        helper(intArrayOf(1,2,3), intArrayOf(3,2,1))
        helper(intArrayOf(1,5,1), intArrayOf(1,1,5))
    }

    fun helper(expected: IntArray, input: IntArray) {
        Solution().nextPermutation(input)

        assertArrayEquals(
                expected,
                input
        )
    }
}