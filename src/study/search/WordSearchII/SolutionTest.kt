package study.search.WordSearchII

import org.junit.Test

class SolutionTest {

    @Test
    fun findWords() {
        val board = arrayOf(
                charArrayOf('o', 'a', 'a', 'n'),
                charArrayOf('e', 't', 'a', 'e'),
                charArrayOf('i', 'h', 'k', 'r'),
                charArrayOf('i', 'f', 'l', 'v')
        )
        val result = Solution().findWords(board, arrayOf("oath", "pea", "eat", "rain"))
        println("result = ${result}")

    }


    fun t1() {

    }
}