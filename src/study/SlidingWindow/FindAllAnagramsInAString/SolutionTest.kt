package study.SlidingWindow.FindAllAnagramsInAString

import org.junit.Test

class SolutionTest {
    @Test
    fun findAnagrams() {
        val result = Solution().findAnagrams(
                "cbaebabacd",
                "abc"
        )
        println("result = ${result}")
    }

    @Test
    fun findAnagrams_1() {
        val result = Solution().findAnagrams(
                "abab",
                "ab"
        )
        println("result = ${result}")
    }
}