package study.array.SlidingWindow.SmallestRangeWithCoveringElementsFromKLists

import org.junit.Test
import java.util.*

class SolutionTest {
    @Test
    fun smallestRange() {
        val ret = Solution().smallestRange(listOf(
                listOf(4, 10, 15, 24, 26),
                listOf(0, 9, 12, 20),
                listOf(5, 18, 22, 30)))
        println("ret = ${Arrays.toString(ret)}")

        assert(ret!!.contentEquals(intArrayOf(20, 24)))
    }

    @Test
    fun test_1() {
        val param = listOf(listOf(-89, 1, 69, 89, 90, 98), listOf(-43, -36, -24, -14, 49, 61, 66, 69), listOf(73, 94, 94, 96), listOf(11, 13, 76, 79, 90), listOf(-40, -20, 1, 9, 12, 12, 14), listOf(-91, -31, 0, 21, 25, 26, 28, 29, 29, 30), listOf(23, 88, 89), listOf(31, 42, 42, 57), listOf(-2, 6, 11, 12, 12, 13, 15), listOf(-3, 25, 34, 36, 39), listOf(-7, 3, 29, 29, 31, 32, 33), listOf(4, 11, 14, 15, 15, 18, 19), listOf(-34, 9, 12, 19, 19, 19, 19, 20), listOf(-26, 4, 47, 53, 64, 64, 64, 64, 64, 65), listOf(-51, -25, 36, 38, 50, 54), listOf(17, 25, 38, 38, 38, 38, 40), listOf(-30, 12, 15, 19, 19, 20, 22), listOf(-14, -13, -10, 68, 69, 69, 72, 74, 75), listOf(-39, 42, 70, 70, 70, 71, 72, 72, 73), listOf(-67, -34, 6, 26, 28, 28, 28, 28, 29, 30, 31))

        val ret = Solution().smallestRange(
                param
        )
        println("ret = ${Arrays.toString(ret)}")
        assert(ret!!.contentEquals(intArrayOf(13, 73)))
    }
}