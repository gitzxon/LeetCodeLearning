package list.single.MergeKSortedList

import list.single.ListNode
import list.single.toArrayList
import list.single.toLinkedList
import org.junit.Assert.*
import org.junit.Test
import java.util.*

class SolutionTest {

    @Test
    fun mergeKLists() {
        helper(
                intArrayOf(1, 4, 5),
                intArrayOf(1, 3, 4),
                intArrayOf(2, 6)
        )

    }

    fun helper(vararg intArrays: IntArray) {
        val lists = Array<ListNode?>(intArrays.size) { index ->
            intArrays[index].toLinkedList()
        }
        lists.forEach {
            println(it?.`val`)
        }

        val ints = Solution().mergeKLists(lists).toArrayList().toIntArray()
        println(Arrays.toString(ints))
    }

}