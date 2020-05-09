package study.array.Permutation.PermutationSequence

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun getPermutation() {
        assertEquals(
                "213",
                Solution().getPermutation(3, 3)
        )
    }

    @Test
    fun test() {
        assertEquals(
                "2314",
                Solution().getPermutation(4, 9)
        )
    }
}