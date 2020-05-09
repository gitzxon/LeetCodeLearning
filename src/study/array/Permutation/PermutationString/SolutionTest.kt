package study.array.Permutation.PermutationString

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun checkInclusion() {
        assertEquals(
                true,
                Solution().checkInclusion(
                        "ab",
                        "eidbaooo"
                )
        )
    }

    @Test
    fun test1() {
        assertEquals(
                false,
                Solution().checkInclusion(
                        "ab",
                        "eidboaoo"
                )
        )
    }
}