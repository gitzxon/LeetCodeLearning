package study.list.single.CopyRandomList

import org.junit.Test

class SolutionTest {

    @Test
    fun copyRandomList() {
        val list = listOf(
                Node(),
                Node(),
                Node()
        )

        list[0].`val` = 0
        list[1].`val` = 1
        list[2].`val` = 2

        list[0].next = list[1]
        list[1].next = list[2]
        list[2].next = null

        list[0].random = list[1]
        list[1].random = list[2]

        val head = list[0]
        val result = Solution().copyRandomList(head)

        println("result = ${result.`val`}")

    }
}