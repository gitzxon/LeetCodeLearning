package study.palindrome.PalindromeSubstrings

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun test3() {
        assertEquals(
                6,
                Solution().countSubstrings("fdsklf")
        )
    }

    @Test
    fun test0() {
        assertEquals(
                3,
                Solution().countSubstrings("abc")
        )

    }

    @Test
    fun test1() {
        assertEquals(
                6,
                Solution().countSubstrings("aaa")
        )
    }

    @Test
    fun test2() {
        assertEquals(
                15,
                Solution().countSubstrings("aaaaa")
        )
    }


}