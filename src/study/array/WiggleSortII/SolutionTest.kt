package study.array.WiggleSortII

import org.junit.Assert.assertArrayEquals
import org.junit.Test
import java.util.*

class SolutionTest {

    @Test
    fun wiggleSort() {
        val nums = intArrayOf(1, 5, 1, 1, 6, 4)
        Solution().wiggleSort(nums)
        println(Arrays.toString(nums))
    }

    @Test
    fun test1() {
        val nums = intArrayOf(1, 3, 2, 2, 3, 1)
        Solution().wiggleSort(nums)
        println(Arrays.toString(nums))
    }

    @Test
    fun test2() {
        val nums = intArrayOf(1, 1, 2, 1, 2, 2, 1)
        Solution().wiggleSort(nums)
        println(Arrays.toString(nums))
    }

    @Test
    fun t3() {
        val nums = intArrayOf(2, 1)
        Solution().wiggleSort(nums)
        assertArrayEquals(
                intArrayOf(1, 2),
                nums
        )
    }

    @Test
    fun t4() {
        val nums = intArrayOf(3,2,1,3)
        Solution().wiggleSort(nums)
        println("Arrays.toString(nums) = ${Arrays.toString(nums)}")
        assertArrayEquals(
                intArrayOf(2,3,1,3),
                nums
        )
    }
}
