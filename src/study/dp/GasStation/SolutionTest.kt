package study.dp.GasStation

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {

    @Test
    fun canCompleteCircuit() {
        val gas = intArrayOf(1, 2, 3, 4, 5)
        val cost = intArrayOf(3, 4, 5, 1, 2)
        assertEquals(
                3,
                Solution().canCompleteCircuit(gas, cost)
        )
    }

    @Test
    fun t1() {
        val gas = intArrayOf(5, 8, 2, 8)
        val cost = intArrayOf(6, 5, 6, 6)
        val gains = intArrayOf(-1, 3, -4, 2)
        assertEquals(3,
                Solution().canCompleteCircuit(gas, cost))
    }
}