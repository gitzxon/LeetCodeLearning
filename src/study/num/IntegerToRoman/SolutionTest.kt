package study.num.IntegerToRoman

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun t1() {
        assertEquals(
                "III",
                Solution().intToRoman(3)
        )
    }

    @Test
    fun t2() {
        assertEquals(
                "IV",
                Solution().intToRoman(4)
        )
    }

    @Test
    fun t3() {

        assertEquals(
                "IX",
                Solution().intToRoman(9)
        )
    }
    @Test
    fun t4() {
        assertEquals(
                "LVIII",
                Solution().intToRoman(58)
        )
    }
    @Test
    fun t5() {
        assertEquals(
                "MCMXCIV",
                Solution().intToRoman(1994)
        )
    }
}