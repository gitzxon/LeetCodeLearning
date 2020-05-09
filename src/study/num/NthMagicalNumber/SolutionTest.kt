package study.num.NthMagicalNumber

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun nthMagicalNumber() {
        assertEquals(
                2,
                Solution().nthMagicalNumber(1,2,3)
        )

        assertEquals(
                6,
                Solution().nthMagicalNumber(4,2,3)
        )


        assertEquals(
                8,
                Solution().nthMagicalNumber(3,6,4)
        )
    }

    @Test
    fun t1() {
        assertEquals(
                16,
                Solution().nthMagicalNumber(3,8,9)
        )
    }

    @Test
    fun t2() {
        assertEquals(
                10,
                Solution().nthMagicalNumber(5,2,4)
        )
    }
}