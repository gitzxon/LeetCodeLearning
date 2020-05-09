package study.AllHard.RemoveInvalidParentheses

import org.junit.Test
import kotlin.test.assertTrue

class SolutionTest {
    @Test
    fun removeInvalidParentheses() {
        val ret = Solution().removeInvalidParentheses("()())()");
        println("ret = ${ret}")
        val equals = ret.toSet() == setOf(
                "()()()",
                "(())()"
        )

        assert(equals)

    }

    @Test
    fun test1() {
        assertTrue {
            Solution().removeInvalidParentheses("(a)())()").toSet() == setOf("(a)()()", "(a())()")
        }
    }

    @Test
    fun test2() {
        val ret = Solution().removeInvalidParentheses("((()")
        println("ret = ${ret}")
        assertTrue {
            Solution().removeInvalidParentheses("((()").toSet() == setOf("()")
        }

    }
}