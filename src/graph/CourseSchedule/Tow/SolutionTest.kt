package graph.CourseSchedule.Tow

import org.junit.Test

import org.junit.Assert.*
import java.util.*

class SolutionTest {

    @Test
    fun findOrder() {
        val array = arrayOf(
                intArrayOf(4, 3),
                intArrayOf(3, 2),
                intArrayOf(2, 1),
                intArrayOf(1, 0))
        val result = graph.CourseSchedule.Tow.Solution().findOrder(5, array)
        println("result = ${Arrays.toString(result)}")

    }

    @Test
    fun findOrder1() {
        val array = arrayOf(
                intArrayOf(1, 0))
        val result = graph.CourseSchedule.Tow.Solution().findOrder(2, array)
        println("result = ${Arrays.toString(result)}")
    }
}