package study.palindrome.LongestPalindromeSubstring

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun longestPalindrome() {
        assertEquals("bab", Solution().longestPalindrome("babad"))
    }

    @Test
    fun test1() {
        assertEquals("bb", Solution().longestPalindrome("cbbd"))
    }

    @Test
    fun test2() {
        assertEquals("aaaa", Solution().longestPalindrome("aaaa"))
    }


    @Test
    fun test3() {
        assertEquals("a", Solution().longestPalindrome("ac"))
    }
}