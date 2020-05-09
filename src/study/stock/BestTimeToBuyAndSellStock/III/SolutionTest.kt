package study.stock.BestTimeToBuyAndSellStock.III

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun maxProfit() {
        assertEquals(
                6,
                Solution().maxProfit(
                        intArrayOf(3, 3, 5, 0, 0, 3, 1, 4)
                )
        )
    }

    @Test
    fun maxProfit_1() {
        assertEquals(
                4,
                Solution().maxProfit(
                        intArrayOf(1,2,3,4,5)
                )
        )
    }

    @Test
    fun maxProfit_2() {
        assertEquals(
                0,
                Solution().maxProfit(
                        intArrayOf(7,6,4,3,1)
                )
        )
    }

    @Test
    fun maxProfit_3() {
        assertEquals(
                7,
                Solution().maxProfit(
                        intArrayOf(6,1,3,2,4,7)
                )
        )
    }
}