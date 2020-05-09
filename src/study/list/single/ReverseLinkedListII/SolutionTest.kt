package study.list.single.ReverseLinkedListII

import study.list.single.toArrayList
import study.list.single.toLinkedList
import org.junit.Test

class SolutionTest {

    @Test
    fun reverseBetween() {
        val content = Solution().reverseBetween(intArrayOf(1, 2, 3, 4, 5).toLinkedList(), 2, 4).toArrayList().toIntArray().contentToString()
        println("content = ${content}")
    }
}