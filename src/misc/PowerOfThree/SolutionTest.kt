package misc.PowerOfThree

import org.junit.Test

import org.junit.Assert.*

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