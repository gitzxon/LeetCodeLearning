package study.string.DecodeString

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun decodeString() {
        val decodedString = Solution().decodeString("3[a]2[bc]")
        println("decodedString = ${decodedString}")
        assertEquals(
                "aaabcbc",
                decodedString
        )
    }

    @Test
    fun test1() {
        assertEquals(
                "accaccacc",
                Solution().decodeString("3[a2[c]]")
        )
    }

    @Test
    fun test2() {
        assertEquals(
                "abcabccdcdcdef",
                Solution().decodeString("2[abc]3[cd]ef")
        )
    }
}