package study.backtracking.CombinationSumII

import org.junit.Test

class SolutionTest {

    @Test
    fun combinationSum2() {
        println(Solution().combinationSum2(intArrayOf(2, 5, 2, 1, 2), 5))
        println(Solution().combinationSum2(intArrayOf(10,1,2,7,6,1,5), 8))


        println(SolutionBetter().combinationSum2(intArrayOf(2, 5, 2, 1, 2), 5))
        println(SolutionBetter().combinationSum2(intArrayOf(10,1,2,7,6,1,5), 8))

    }
}