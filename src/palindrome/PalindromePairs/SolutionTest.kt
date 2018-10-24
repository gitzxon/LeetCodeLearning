package palindrome.PalindromePairs

import org.junit.Test

import org.junit.Assert.*
import java.util.*

class SolutionTest {

    @Test
    fun palindromePairs() {
        helper(arrayOf("abcd", "dcba", "lls", "s", "sssll"))
        // expected : [0,1],[1,0],[3,2],[2,4]

    }

    @Test
    fun test1() {
        helper(arrayOf("a",""))
    }

    @Test
    fun test2() {
        helper(arrayOf(
                "a","b","c","ab","ac","aa"
        ))
//      output;   [[0,5],[1,3],[2,4]]
//      expected;  [[3,0],[1,3],[4,0],[2,4],[5,0],[0,5]]

    }

    private fun helper(list: Array<String>) {
        val result = Solution().palindromePairs(list)

        println(result.joinToString {
            it.get(0).toString() + "_" + it.get(1).toString()
        })

    }


}