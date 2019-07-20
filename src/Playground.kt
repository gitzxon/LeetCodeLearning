import org.junit.Test

class Playground {

    @Test
    fun test() {
        val name = "mice"
        val age = 18
        println("我是 %s，我今年 %d 岁".format(name, age))

        listOf(
                listOf(""),
                listOf(""),
                listOf(""),
                listOf("")
        ).flatMap {
            it + "flatMap"
        }
    }
}
