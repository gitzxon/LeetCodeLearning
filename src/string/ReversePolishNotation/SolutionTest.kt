package string.ReversePolishNotation

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun generateReversePolishNotation() {
        Solution().generateReversePolishNotation("(1+(49+5+2)-3)+(6+8)")
        Solution().generateReversePolishNotation("1 + 1")
    }
}