package study.sync

import org.junit.Test

/**
 * todo : 怎么测试代码不 work 呢？
 */
class TestSyncMethodTest {

    @Volatile var a : Long = 0
    @Volatile var b : Long = 0

    @Test
    fun a() {
        val test = TestSyncMethod()
        Thread {
            test.a()
                a = System.currentTimeMillis()
        }
        Thread.sleep(1000)
        Thread {
            test.b()
            b = System.currentTimeMillis()
        }
        println("123")

        Thread.sleep(6000)
        println("a = ${a}")
        println("b = ${b}")
    }
}