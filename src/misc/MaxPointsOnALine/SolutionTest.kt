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
                        Point(1, 1),
                        Point(3, 2),
                        Point(5, 3),
                        Point(4, 1),
                        Point(2, 3),
                        Point(1, 4)
                )
        ))

//        val line1 = Solution().getLine(Solution.PointWrapper(Point(1, 4)), Solution.PointWrapper(Point(4, 1)))
//        val line2 = Solution().getLine(Solution.PointWrapper(Point(1, 1)), Solution.PointWrapper(Point(1, 4)))
//        println("line1 = ${line1}")
//        println("line2 = ${line2}")
//        val set: HashSet<Solution.Line> = HashSet()
//        set.add(line1)
//        set.add(line2)
//        println("set.size = ${set.size}")
//        val map = HashMap<Solution.Line, Int>()
//        map.put(line1, 1)
//        map.put(line2, 2)
//        println("map.size = ${map.size}")
    }
}