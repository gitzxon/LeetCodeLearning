package study.string.ReversePolishNotation

import org.junit.Test

class SolutionTest {

    @Test
    fun generateReversePolishNotation() {
        Solution().generateReversePolishNotation("(1+(49+5+2)-3)+(6+8)")
        Solution().generateReversePolishNotation("1 + 1")
    }
}