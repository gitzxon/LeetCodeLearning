package study.search.WordSearch

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun exist() {
        val board =
                arrayOf(charArrayOf('A', 'B', 'C', 'E'),
                        charArrayOf('S', 'F', 'C', 'S'),
                        charArrayOf('A', 'D', 'E', 'E'))


        assertEquals(
                true,
                Solution().exist(board, "ABCCED")
        )
        assertEquals(true,
                Solution().exist(board, "SEE")

        )

        assertEquals(false,
                Solution().exist(board, "ABCD")
        )
    }
}