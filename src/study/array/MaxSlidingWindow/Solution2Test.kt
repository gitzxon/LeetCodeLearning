package study.array.MaxSlidingWindow

import org.junit.Assert.assertArrayEquals
import org.junit.Test
import java.util.*

class Solution2Test {

    @Test
    fun test1() {

        println(Arrays.toString(Solution2().maxSlidingWindow(intArrayOf(1,3,-1,-3,5,3,6,7), 3)))

        assertArrayEquals(
                intArrayOf(3,3,5,5,6,7),
                Solution2().maxSlidingWindow(intArrayOf(1,3,-1,-3,5,3,6,7), 3)
        )

    }

    @Test
    fun test2() {
        val result = Solution2().maxSlidingWindow(
                intArrayOf(9,8,7,6),
                3
        )
        println(Arrays.toString(result))
        assertArrayEquals(
                intArrayOf(9,8),
                result
        )
    }

    @Test
    fun test3() {
        val result = Solution2().maxSlidingWindow(
                intArrayOf(7,2,4),
                2
        )
        assertArrayEquals(
                intArrayOf(7, 4),
                result
        )
    }


    @Test
    fun test4() {
        assertArrayEquals(
                intArrayOf(1),
                Solution2().maxSlidingWindow(intArrayOf(1), 1)
        )
    }
}