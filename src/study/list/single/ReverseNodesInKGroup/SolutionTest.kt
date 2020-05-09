package study.list.single.ReverseNodesInKGroup

import study.list.single.toArrayList
import study.list.single.toLinkedList
import org.junit.Test

import org.junit.Assert.*
import java.util.*

class SolutionTest {

    @Test
    fun reverseKGroup() {
        helper(intArrayOf(1, 2, 3, 4, 5), 2, intArrayOf(2, 1, 4, 3, 5))
        helper(intArrayOf(1, 2, 3, 4, 5), 3, intArrayOf(3, 2, 1, 4, 5))
    }

    @Test
    fun revert() {
        val head = intArrayOf(1,2,3,4,5).toLinkedList()
        var tail = head!!.next!!.next
        val result = Solution().revert(head, tail)
        val resultIntArray = result[0].toArrayList().toIntArray()
        println(Arrays.toString(resultIntArray))
    }

    fun helper(intArray: IntArray, k: Int, expeactedIntArray: IntArray) {
        val result = Solution().reverseKGroup(intArray.toLinkedList(), k).toArrayList().toIntArray()
        assertArrayEquals(
                expeactedIntArray,
                result
        )
    }
}