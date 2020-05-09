package study.array.New21Game

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun new21Game() {
        assertEquals(
                1.00,
                Solution().new21Game(10, 1, 10),
                0.000001
        )
    }

    @Test
    fun new21Game_1() {
        assertEquals(
                0.60,
                Solution().new21Game(6, 1, 10),
                0.000001
        )
    }

    @Test
    fun new21Game_2() {
        assertEquals(
                0.73278,
                Solution().new21Game(21, 17, 10),
                0.00001
        )
    }

    @Test
    fun new21Game_3() {
        Solution().new21Game(
                9676,
                8090,
                3056)
//        assertEquals(
//                0.73278,
//                Solution().new21Game(
//                        9676,
//                        8090,
//                        3056),
//                0.00001
//        )
    }

}



