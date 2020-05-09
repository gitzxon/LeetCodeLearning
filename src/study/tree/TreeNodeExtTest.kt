package study.tree

import org.junit.Test

class TreeNodeExtTest {

    @Test
    fun test() {
        helper("[10,5,15,3,7,null,18]")
        println("========")
        helper("[10,5,15,3,7,13,18,1,null,6]")
    }

    fun helper(input: String) {
        val root = input.toTree()
        val list = input.split(",", "[", "]").filter { it.isNotEmpty() }

        val rootArray = root.toList().toTypedArray()
        val listArray = list.toTypedArray()
        val equals = listArray contentEquals rootArray

        rootArray.forEach {
            println("root it = ${it}")
        }

        listArray.forEach {
            println("list it = ${it}")
        }

        assert(equals)
    }
}