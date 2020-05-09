package study.misc.MaxPointsOnALine

import study.misc.Point
import org.junit.Test

class SolutionTest {

    @Test
    fun maxPoints() {

//        helper(arrayOf(
//                Point(1, 1),
//                Point(3, 2),
//                Point(5, 3),
//                Point(4, 1),
//                Point(2, 3),
//                Point(1, 4)
//        ))

        helper(arrayOf(
                Point(84, 250),
                Point(0, 0),
                Point(1, 0),
                Point(0, -70),
                Point(0, -70),
                Point(1, -1),
                Point(21, 10),
                Point(42, 90),
                Point(-42, -230)))
        val array = arrayOf(
                Point(84, 250),
                Point(0, 0),
                Point(1, 0),
                Point(0, -70),
                Point(0, -70),
                Point(1, -1),
                Point(21, 10),
                Point(42, 90),
                Point(-42, -230))
//        for (point in array) {
//            println(point.x.toString() + ",")
//        }
//        println("=====")
//        for (point in array) {
//            println(point.y.toString() + ",")
//        }
    }

    fun helper(points: Array<Point>) {
        val ret = Solution().maxPoints(
                points
        )
        println("ret = ${ret}")
    }
}