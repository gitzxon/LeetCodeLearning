package study.circle.FriendCircle

import org.junit.Test

class SolutionTest {

    @Test
    fun findCircleNum() {

        val test1 = Solution().findCircleNum(
                arrayOf(
                        intArrayOf(1, 1, 0),
                        intArrayOf(1, 1, 0),
                        intArrayOf(0, 0, 1)
                )
        )
        println("test1 = ${test1}")

        val test2 = Solution().findCircleNum(
                arrayOf(
                        intArrayOf(1, 1, 0),
                        intArrayOf(1, 1, 1),
                        intArrayOf(0, 1, 1)
                )
        )
        println("test2 = ${test2}")
    }
}