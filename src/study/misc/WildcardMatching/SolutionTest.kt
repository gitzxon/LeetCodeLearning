package study.misc.WildcardMatching

import org.junit.Test

class SolutionTest {
    @Test
    fun comparison() {
        assert(Solution().isMatch("bbbbbbbbbbbb", "*bbbb"))
    }
}