package study.num.FractionToRecuringDecimal

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun fractionToDecimal() {
        assertEquals(
                "0.5",
                Solution().fractionToDecimal(1, 2)
        )

        assertEquals(
                "2",
                Solution().fractionToDecimal(2, 1)
        )

        assertEquals(
                "0.(6)",
                Solution().fractionToDecimal(2, 3)
        )
    }

    @Test
    fun t1() {
        val result = Solution().fractionToDecimal(4, 333)
        println("result = ${result}")
    }

    @Test
    fun t2() {
        val result = Solution().fractionToDecimal(-50, 8)
        println("result = ${result}")
        assertEquals(
                "-6.25",
                result
        )
    }

    @Test
    fun t3() {
        val result = Solution().fractionToDecimal(-1, -2147483648)
        println("result = ${result}")
    }
}