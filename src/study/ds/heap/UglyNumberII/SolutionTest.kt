package study.ds.heap.UglyNumberII

import org.junit.Test

import org.junit.Assert.*
import java.util.*

class SolutionTest {

    @Test
    fun nthUglyNumber() {

        val firstTen = intArrayOf(1, 2, 3, 4, 5, 6, 8, 9, 10, 12)
        firstTen.forEachIndexed { index, i ->

            val ugly = Solution().nthUglyNumber(index + 1)
            assertEquals(
                    i,
                    ugly
            )
        }

        assertEquals(
                612220032,
                Solution().nthUglyNumber(1432)
        )
    }

    @Test
    fun priorityQueue() {

        val priorityQueue = PriorityQueue<Long>({ o1, o2 ->
            return@PriorityQueue (o1 - o2).toInt()
        })

        priorityQueue.add(1)
        priorityQueue.add(2)
        priorityQueue.add(3)
        val peek = priorityQueue.peek()
        println("peek = ${peek}")
    }

}