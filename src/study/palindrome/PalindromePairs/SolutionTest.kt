package study.palindrome.PalindromePairs

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun palindromePairs() {
        val res = helper(arrayOf("abcd", "dcba", "lls", "s", "sssll"))
        // expected : [0,1],[1,0],[3,2],[2,4]
        assertEquals(4, res.size)
    }

    @Test
    fun test1() {

        assertEquals(2, helper(arrayOf("a", ""))?.size)
    }

    @Test
    fun test2() {
        helper(arrayOf(
                "a", "b", "c", "ab", "ac", "aa"
        ))
//      output;   [[0,5],[1,3],[2,4]]
//      expected;  [[3,0],[1,3],[4,0],[2,4],[5,0],[0,5]]
//        , 1_0, , 2_0, , , ,

    }

    @Test
    fun test3() {

        assertEquals(4,
                helper(arrayOf(
                        "abcd", "dcba", "lls", "s", "sssll"
                )).size)

        // expected: [[0,1],[1,0],[3,2],[2,4]]
        // actual : [[2,4],[3,2]]
    }

    @Test
    fun test4() {
        assertEquals(
                4,
                helper(arrayOf(
                        "a", "abc", "aba", ""
                )).size
        )

        // e: [[0,3],[3,0],[2,3],[3,2]]
    }

    @Test
    fun test5() {
        assertEquals(
                6,
                helper(arrayOf(
                        "a","b","c","ab","ac","aa"
                )).size
        )
        // expected: [[3,0],[1,3],[4,0],[2,4],[5,0],[0,5]]
        // [[0,5],[1,3],[2,4],[3,0],[4,0]]
    }

    private fun helper(list: Array<String>): MutableList<MutableList<Int>> {
        val result = Solution().palindromePairs(list)

        println(result.joinToString {
            it.get(0).toString() + "_" + it.get(1).toString()
        })

        return result
    }


}