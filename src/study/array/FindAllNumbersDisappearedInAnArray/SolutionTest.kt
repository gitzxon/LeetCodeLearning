package study.array.FindAllNumbersDisappearedInAnArray

import org.junit.Test

class SolutionTest {
    @Test
    fun findDisappearedNumbers() {
        val result = Solution().findDisappearedNumbers(intArrayOf(4,3,2,7,8,2,3,1))
        println(result.joinToString(", "))
    }
}