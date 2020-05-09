package study.array.FindAllDuplicatesInAnArray

import org.junit.Test

class SolutionTest {
    @Test
    fun findDuplicates() {
        val result = Solution().findDuplicates(
                intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)
        )

        println(result.joinToString(", "))

    }
}