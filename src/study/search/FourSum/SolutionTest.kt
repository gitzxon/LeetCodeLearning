package study.search.FourSum

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun fourSum() {
        val result = Solution().fourSum(
                intArrayOf(-2, -1, 0, 0, 1, 2),

//                intArrayOf(1, 0, -1, 0, -2, 2),
                0
        )
//        [
//            [-1,  0, 0, 1],
//            [-2, -1, 1, 2],
//            [-2,  0, 0, 2]
//        ]
        result.forEach {
            println(it)
        }
        assertEquals(3, result.size)
    }

    @Test
    fun test1() {

        val result = Solution().fourSum(
                intArrayOf(0,0,0,0),
                0
        )

        assertEquals(
                1,
                result.size
        )

    }
}