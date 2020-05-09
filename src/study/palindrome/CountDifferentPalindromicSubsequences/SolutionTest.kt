package study.palindrome.CountDifferentPalindromicSubsequences

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun countPalindromicSubsequences() {
        assertEquals(
                6,
                Solution().countPalindromicSubsequences("bccb")
        )
    }
}