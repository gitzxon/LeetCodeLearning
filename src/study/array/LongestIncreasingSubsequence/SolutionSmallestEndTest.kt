package study.array.LongestIncreasingSubsequence

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionSmallestEndTest {

    @Test
    fun lengthOfLIS() {
        val result = SolutionSmallestEnd.Solution().lengthOfLIS(intArrayOf(
                10, 9, 2, 5, 3, 7, 101, 18
        ))
        println("result = ${result}")
        assertEquals(4, result)

        assertEquals(6, SolutionSmallestEnd.Solution().lengthOfLIS(
                intArrayOf(11, 12, 13, 14, 15, 6, 7, 8, 101, 18)
        ))


    }

    @Test
    fun lengthOfLis_case1() {
        assertEquals(6, SolutionSmallestEnd.Solution().lengthOfLIS(
                intArrayOf(3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12)
        ))
    }

    @Test
    fun test() {
        val max = Integer.MAX_VALUE
        val min = Integer.MIN_VALUE

        println("max = ${max}")
        println("min = ${min}")
        println("max + 1 = ${max + 1}")

        println("min + max = ${min + max}")
    }
}