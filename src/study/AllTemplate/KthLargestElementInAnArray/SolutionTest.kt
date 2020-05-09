package study.AllTemplate.KthLargestElementInAnArray

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun findKthLargest() {
        val ret = Solution().findKthLargest(
                intArrayOf(3,2,1,5,6,4),
                2
        )
        println("ret = ${ret}")
        assertEquals(5, ret)
    }

    @Test
    fun findKthLargest_1() {
        val ret = Solution().findKthLargest(
                intArrayOf(3,2,3,1,2,4,5,5,6),
                4
        )
        println("ret = ${ret}")
        assertEquals(4, ret)
    }


    @Test
    fun findKthLargest_2() {
        val ret = Solution().findKthLargest(
                intArrayOf(5,2,4,1,3,6,0),
                4
        )
        println("ret = ${ret}")
        assertEquals(3, ret)
    }

}