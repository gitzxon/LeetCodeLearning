package study.array.PancakeSorting

import org.junit.Test

class SolutionTest {

    @Test
    fun pancakeSort() {
        val list: MutableList<Int> = Solution().pancakeSort(intArrayOf(3, 2, 4, 1))
        println("list = ${list}")
    }
}