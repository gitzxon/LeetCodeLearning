import org.junit.Test

import org.junit.Assert.*

/**
 * playground,
 * 用来处理数据。
 */
class MainTest {

    @Test
    fun main() {

        "[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]"
                .split(" ", "[", "]", ",")
                .filter { it.isNotEmpty() }
                .chunked(2)
                .forEach {
                    println("intArrayOf(${it[0]}, ${it[1]}),")
                }

    }


}