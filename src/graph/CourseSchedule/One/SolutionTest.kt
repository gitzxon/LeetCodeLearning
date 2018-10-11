package graph.CourseSchedule.One

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun canFinish() {
        val array = arrayOf(
                intArrayOf(4, 3),
                intArrayOf(3, 2),
                intArrayOf(2, 1),
                intArrayOf(1, 0))
        val result = Solution().canFinish(5, array)
        println("result = ${result}")

    }
}