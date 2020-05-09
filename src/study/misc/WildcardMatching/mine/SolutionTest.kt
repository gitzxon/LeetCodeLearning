package study.misc.WildcardMatching.mine

import org.junit.Test

class SolutionTest {
    @Test
    fun test1() {
        assert(Solution().isMatch("bbb", "*b"))
    }

    @Test
    fun test2() {
        assert(!Solution().isMatch("aa", "a"))
    }

    @Test
    fun test3() {
        assert(!Solution().isMatch("acdcb", "a*c?b"))
    }
}