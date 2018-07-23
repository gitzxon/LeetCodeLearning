package list.single.SplitLinkedListInParts

import list.single.ListNode
import list.single.toArrayList
import list.single.toLinkedList
import org.junit.Test

import org.junit.Assert.*
import java.util.*

class SolutionTest {

    @Test
    fun splitListToParts() {
        helper(
                intArrayOf(1,2,3),
                5
        )

        helper(
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                3
        )
    }

    fun helper(values: IntArray, k: Int) {
        val head= values.toLinkedList()
        val result:Array<ListNode?> = Solution().splitListToParts(head, k)

        for (listNode in result) {
            println(listNode?.toArrayList())
        }
    }
}