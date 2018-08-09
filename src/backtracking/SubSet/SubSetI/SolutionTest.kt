package backtracking.SubSet.SubSetI

import org.junit.Test

import org.junit.Assert.*
import java.util.*

class SolutionTest {

    @Test
    fun subsets() {
        val result = Solution().subsets(intArrayOf(1, 2, 3))

        result.forEach {
            println(it)
        }

        assertEquals(
                8,
                result.size
        )


    }
}