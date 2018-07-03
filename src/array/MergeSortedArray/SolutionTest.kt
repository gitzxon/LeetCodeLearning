package array.MergeSortedArray

import org.junit.Test

import org.junit.Assert.*
import java.util.*

class SolutionTest {

    @Test
    fun merge() {

        val a = intArrayOf(1,2,3,0,0,0)
        Solution().merge(
                a,
                3,
                intArrayOf(2,5,6),
                3
        )
        println(Arrays.toString(a))

    }
}