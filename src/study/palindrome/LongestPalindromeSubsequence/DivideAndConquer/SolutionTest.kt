package study.palindrome.LongestPalindromeSubsequence.DivideAndConquer

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun longestPalindromeSubseq() {
        val ret = Solution().longestPalindromeSubseq("cbbd")
        assertEquals(2, ret)
    }

    @Test
    fun test1() {
        val ret = Solution().longestPalindromeSubseq("bbbab")
        assertEquals(4, ret)
    }
}