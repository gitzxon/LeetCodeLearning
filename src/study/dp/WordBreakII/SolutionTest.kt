package study.dp.WordBreakII

import org.junit.Test

class SolutionTest {

    @Test
    fun wordBreak() {
        helper("catsanddog", arrayListOf("cat", "cats", "and", "sand", "dog"))
        helper("pineapplepenapple", arrayListOf("apple", "pen", "applepen", "pine", "pineapple"))
        helper("catsandog", arrayListOf("cats", "dog", "sand", "and", "cat"))

        helper (
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                arrayListOf("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")
        )


    }

    fun helper(s: String, dict: ArrayList<String>) {
        val solution = Solution()
        val result = solution.wordBreak(s, dict)
        print(result)
    }
}