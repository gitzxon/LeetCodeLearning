package study.graph.CourseSchedule.III

import org.junit.Test
import java.util.*

class SolutionTest {

    @Test
    fun scheduleCourse() {
        helper(arrayOf(
                intArrayOf(100, 200),
                intArrayOf(200, 1300),
                intArrayOf(1000, 1250),
                intArrayOf(2000, 3200)))

        helper(arrayOf(
                intArrayOf(5, 5),
                intArrayOf(4, 6),
                intArrayOf(2, 6)
        ))

//        ((2,5),(2,19),(1,8),(1,3))
        helper(arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 5),
                intArrayOf(1, 8),
                intArrayOf(2, 19)
        ))


        helper(arrayOf(
                intArrayOf(9, 10),
                intArrayOf(3, 12),
                intArrayOf(7, 17),
                intArrayOf(4, 18),
                intArrayOf(10, 19),
                intArrayOf(10, 20),
                intArrayOf(5, 20)
        ))


    }

    fun helper(courseList: Array<IntArray>) {
        val result = Solution().scheduleCourse(courseList)
        println("result = ${result}")
    }

    @Test
    fun testPriorityQueue() {
        val queue = PriorityQueue<Int>(kotlin.Comparator { o1, o2 -> o1 - o2 })
        queue.add(1)
        queue.add(3)
        queue.add(2)

        while (queue.size !=0) {
            println("queue = ${queue.remove()}")
        }

    }

}