package study.dp.WordBreak

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun wordBreak() {
        val solution = Solution()
        assertEquals(true, solution.wordBreak("leetcode", arrayListOf("leet", "code")))
        assertEquals(true, solution.wordBreak("applepenapple", arrayListOf("apple", "pen")))
        assertEquals(false, solution.wordBreak("catsandog", arrayListOf("cats", "dog", "sand", "and", "cat")))

        assertEquals(true, solution.wordBreak("aaaaaaa", arrayListOf("aaaa", "aaa")))

    }
}