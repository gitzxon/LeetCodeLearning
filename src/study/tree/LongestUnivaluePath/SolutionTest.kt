package study.tree.LongestUnivaluePath

import org.junit.Test
import study.tree.toTree

class SolutionTest {

    @Test
    fun longestUnivaluePath() {
        val result = Solution().longestUnivaluePath("[5,4,5,1,1,null,5]".toTree())
        println("result = ${result}")
    }

    @Test
    fun test1() {
        val result = Solution().longestUnivaluePath("[1,4,5,4,4,null,5]".toTree())
        println("result = ${result}")
    }

    @Test
    fun test_49() {
        val result = Solution().longestUnivaluePath("[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]".toTree())
        println("resutl = ${result}")
    }
}