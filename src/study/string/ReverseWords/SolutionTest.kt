package study.string.ReverseWords

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun reverseWords() {
        assertEquals(
                "blue is sky the",
                Solution().reverseWords("the sky is blue")
        )
    }
}