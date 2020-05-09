package study.array.SubstringwithConcatenationofAllWords

import org.junit.Test

class SolutionTest {
    @Test
    fun findSubstring() {
        val ret = Solution().findSubstring(
                "barfoothefoobarman",
                arrayOf("foo", "bar")
        )
        println("ret = ${ret}")
    }

    @Test
    fun test1() {
        val ret = Solution().findSubstring(
                "wordgoodgoodgoodbestword",
                arrayOf("word", "good", "best", "word")
        )

        println("ret = ${ret}")

    }

    @Test
    fun test2() {
        val ret = Solution().findSubstring(
                "lingmindraboofooowingdingbarrwingmonkeypoundcake",
                arrayOf("fooo", "barr", "wing", "ding", "wing")
        )

        println("ret = ${ret}")
    }

    @Test
    fun test3() {
        val ret = Solution().findSubstring(
                "wordgoodgoodgoodbestword",
                arrayOf("word", "good", "best", "good")
        )

        println("ret = ${ret}")
    }

    @Test
    fun test4() {
        val ret = Solution().findSubstring("cbaccbcbbc", arrayOf("cb", "bc"))
        println("ret = ${ret}")
        assert(arrayOf(6).contentDeepEquals(ret.toTypedArray()))
    }
}