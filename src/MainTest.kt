import org.junit.Test
import java.util.concurrent.Exchanger

/**
 * playground,
 * 用来处理数据。
 */
class MainTest {

    @Test
    fun testExchanger() {

        val exchanger = Exchanger<String>()
        
        Thread {
            val resultB = "resultFrom thread B"
            println("threadB wait for thread A")
            val resultA = exchanger.exchange(resultB)
            println("in thread B, get result from thread A : $resultA" )
        }.start()

        try {
            val resultA = "result from thread A"
            println("thread A wait for thread B")
            val resultB = exchanger.exchange(resultA)
            println("in thread A, get result from thread B : $resultB" )
        } catch (e: Exception) {

        }

    }

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