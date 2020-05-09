package study.dp.LongestValidParentheses

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun longestValidParentheses() {
        val result = Solution().longestValidParentheses("())")
        println("result = ${result}")
        assertEquals(
                2, result
        )
    }

    @Test
    fun test1() {

        val result = Solution().longestValidParentheses(")()())")
        println("result = ${result}")
        assertEquals(
                4, result
        )
    }

    @Test
    fun test2() {
        val result = Solution().longestValidParentheses("()(())")
        println("result = ${result}")
        assertEquals(
                6, result
        )
    }
}