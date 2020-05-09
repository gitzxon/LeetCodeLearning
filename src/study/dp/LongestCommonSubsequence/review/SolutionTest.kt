package study.dp.LongestCommonSubsequence.review

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun test1() {
        assertEquals(
                3,
                Solution().longestCommonSubsequence(
                        "abcde", "ace"
                )
        )
    }
}