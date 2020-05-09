package study.list.single.SwapNodesInPairs

import study.list.single.toArrayList
import study.list.single.toLinkedList
import org.junit.Test

class SolutionTest {

    @Test
    fun swapPairs() {

        val result = Solution().swapPairs(intArrayOf(1,2,3,4).toLinkedList()).toArrayList().toIntArray()
        println("result = ${result.contentToString()}")
    }
}