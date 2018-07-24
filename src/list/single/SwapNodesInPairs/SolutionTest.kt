package list.single.SwapNodesInPairs

import list.single.toArrayList
import list.single.toLinkedList
import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun swapPairs() {

        val result = Solution().swapPairs(intArrayOf(1,2,3,4).toLinkedList()).toArrayList().toIntArray()
        println("result = ${result.contentToString()}")
    }
}