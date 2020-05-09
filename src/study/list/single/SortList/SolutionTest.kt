package study.list.single.SortList

import study.list.single.ListNode
import study.list.single.toArrayList
import study.list.single.toLinkedList
import org.junit.Test

import kotlin.test.assertEquals

class SolutionTest {

    @Test
    fun sortList() {
        val listNode = Solution().sortList(helper(intArrayOf(4, 2, 1, 3)))
        val arrayList = listNode.toArrayList()
        assertEquals(
                arrayOf<Int>(1, 2, 3, 4).asList(),
                arrayList
        )
    }

    private fun helper(intArray: IntArray): ListNode? {
        return intArray.toLinkedList()
    }
}