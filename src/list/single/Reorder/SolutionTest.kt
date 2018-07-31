package list.single.Reorder

import list.single.toArrayList
import list.single.toLinkedList
import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun reorderList() {
        helper(
                intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(1, 5, 2, 4, 3)
        )

        helper(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(1, 4, 2, 3)
        )
    }

    fun helper(intArray: IntArray, expectedIntArray: IntArray) {
        val list = intArray.toLinkedList()
        Solution().reorderList(list)
        val result = list.toArrayList().toIntArray()
        assertArrayEquals(
                expectedIntArray,
                result
        )
    }
}