package list.single.ReverseLinkedListII

import list.single.toArrayList
import list.single.toLinkedList
import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun reverseBetween() {
        val content = Solution().reverseBetween(intArrayOf(1, 2, 3, 4, 5).toLinkedList(), 2, 4).toArrayList().toIntArray().contentToString()
        println("content = ${content}")
    }
}