import java.nio.ByteBuffer
import java.nio.ByteOrder

class Playground {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("${0b1111}%16 = ${0b1111 % 16}")
            println("${0b11111}%16 = ${0b11111 % 16}")
            println("${0b111111}%16 = ${0b111111 % 16}")
            println("${0b1111111}%16 = ${0b1111111 % 16}")
//            Playground().main1(arrayOf())

            println("little endian")
            ByteBuffer.allocate(Integer.BYTES)
                    .order(ByteOrder.LITTLE_ENDIAN)
                    .putInt(6).array()
                    .forEach {
                        println("byte = ${it}")
                    }

            println("big endian")
            ByteBuffer.allocate(Integer.BYTES)
                    .order(ByteOrder.BIG_ENDIAN)
                    .putInt(6).array()
                    .forEach {
                        println("byte = ${it}")
                    }
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
