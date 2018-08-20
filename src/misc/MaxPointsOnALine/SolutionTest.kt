package misc.MaxPointsOnALine

import misc.Point
import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun maxPoints() {
//        val a = Solution().maxPoints(
//                arrayOf(Point(1, 1), Point(2, 2), Point(3, 3))
//        )
//        println(a)
//
//        val b = Solution().maxPoints(
//                arrayOf(
//                        Point(1,1),
//                        Point(1,1),
//                        Point(1,1)
//
//                )
//        )
//        println(b)

        println(Solution().maxPoints(
                arrayOf(
                        Point(1,1),
                        Point(3,2),
                        Point(5,3),
                        Point(4,1),
                        Point(2,3),
                        Point(1,4)
                )
        ))
    }
}