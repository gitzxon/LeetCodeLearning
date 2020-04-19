

class Playground {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Playground().main1(arrayOf())
        }
    }

    fun main1(args: Array<String>) {

        val list = ArrayList<Int>().apply {
            this.add(0)
            this.add(1)
        }

        val list1 = ArrayList<Int>().apply {
            this.add(0)
            this.add(1)
        }

        println("list1 === list = ${list1 === list}")
        println("list1 == list = ${list1 == list}")


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
