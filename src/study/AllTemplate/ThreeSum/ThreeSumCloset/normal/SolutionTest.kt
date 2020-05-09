package study.AllTemplate.ThreeSum.ThreeSumCloset.normal

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun threeSumClosest() {

        kotlin.test.assertEquals(2,
                Solution().threeSumClosest(
                        intArrayOf(-1, 2, 1, -4),
                        1
                )
        )

    }

    @Test
    fun t1() {
        kotlin.test.assertEquals(
                0,
                Solution().threeSumClosest(intArrayOf(0, 2, 1, -3), 1)
        )
    }

    @Test
    fun t2() {
        kotlin.test.assertEquals(-1,
                Solution().threeSumClosest(intArrayOf(1, 1, -1, -1, 3), -1)
        )
    }

    @Test
    fun t3() {
        kotlin.test.assertEquals(
                157,
                Solution().threeSumClosest(intArrayOf(-7, -71, -7, -13, 45, 46, -50, 83, -29, -72, 9, 32, -74, 81, 68, 92, -31, 28, -46, -86, -70, 31, -62, -20, -56, 97, -41, 21, 81, 17, -14, 56, 69, 16, 25, -38, 65, -48, 15, 16, -25, 68, -41, 46, -56, -2, -3, 82, 8, 19, -32, 62, 92, -56, -9, 43, 50, 100, 66, -45, 41, -24, -4, 83, -36, 79, 24, 97, 82, 89, -56, -91, 75, -64, -68, 96, -55, -52, -58, -37, 68, 27, 89, -40, -42, 94, -92, -70, 40, 74, 75, -15, 54, -54, 0, 4, -39, 93, 88, -31, -26, 93, 8, -85, -62, 89, -93, 98, 4, -58, 8, 5, -93, 7, 30, -75, 63, 41, 62, -52, 49, 93, -11, 87, 7, 52, 5, -96, -56, 43, -41, -75, -16, 73, 6, 35, -32, 62, -50, -57, -25, 5, -32, 94, -70, 6, 19, -12, 63, -47, 76, -57, 41, -49, -33, -15, -81, 55, 88, 67, -51, 100, -19, -39, 62, 84, -100, 78, -24, 31, -32, -83, 33, -25, 86, 9, -30, -40, 52, 64, -30, -17, 19, -69, -89, -67, -79, -100, -53), 157)
        )
    }

    @Test
    fun t4() {
        assertEquals(
                3,
                Solution().threeSumClosest(
                        intArrayOf(1,1,1,1),
                        0
                )
        )
    }

}