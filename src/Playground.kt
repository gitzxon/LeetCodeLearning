class Playground {
    // Kotlin
    fun main(args: Array<String>) {
        val methodName = "main"
        multiplyByTwo(5) {
            result: Int -> println("call method $methodName, Result is: $result")
            return@multiplyByTwo
        }
        println("end of main")
    }

    inline fun multiplyByTwo(
            num: Int,
            crossinline lambda: (result: Int) -> Unit): Int {
        val result = num * 2
        lambda.invoke(result)
        return result
    }

}
