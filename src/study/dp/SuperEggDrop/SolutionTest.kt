package study.dp.SuperEggDrop

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun superEggDrop() {
        val ret = Solution().superEggDrop(1, 2)
        println("ret = ${ret}")
        assertEquals(2, ret)
    }

    @Test
    fun superEggDrop_1() {
        val ret = Solution().superEggDrop(2, 6)
        println("ret = ${ret}")
        assertEquals(3, ret)
    }


    @Test
    fun superEggDrop_2() {
        val ret = Solution().superEggDrop(3, 14)
        println("ret = ${ret}")
        assertEquals(4, ret)
    }
}