package study.search.WordInMatrix

import org.junit.Test

class SolutionTest {

    @Test
    fun hasPath() {
        // ABCEHJIG
        // SFCSLOPQ
        // ADEEMNOE
        // ADIDEJFM
        // VCEIFGGS
        val result = Solution().hasPath(
                "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(),
                5,
                8,
                "SLHECCEIDEJFGGFIE".toCharArray()
        )
        println("result = ${result}")
    }
}