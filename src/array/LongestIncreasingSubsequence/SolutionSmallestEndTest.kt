package array.LongestIncreasingSubsequence

import org.junit.Test

import org.junit.Assert.*

class SolutionSmallestEndTest {

    @Test
    fun lengthOfLIS() {
        val result = SolutionSmallestEnd().lengthOfLIS(intArrayOf(
                10,9,2,5,3,7,101,18
        ))
        println("result = ${result}")
    }
}