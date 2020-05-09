package study.misc.PowerOfThree

import org.junit.Test

class SolutionTest {

    @Test
    fun isPowerOfThree() {
        var max = 3
        while (max < Integer.MAX_VALUE && max * 3 > 0) {
            max *= 3
            println("max = ${max}")
        }
        println("max = ${max}")
    }
}