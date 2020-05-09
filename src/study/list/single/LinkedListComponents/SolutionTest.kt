package study.list.single.LinkedListComponents

import study.list.single.toLinkedList
import org.junit.Test

class SolutionTest {

    @Test
    fun numComponents() {

        helper(intArrayOf(0, 1, 2, 3), intArrayOf(0, 1, 3))
        helper(intArrayOf(0, 1, 2, 3, 4), intArrayOf(0, 3, 1, 4))
    }

    private fun helper(listNodeValues: IntArray, g: IntArray) {
        val head = listNodeValues.toLinkedList()
        val result = Solution().numComponents(
                head,
                g
        )
        println("result = ${result}")
    }
}