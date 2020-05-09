package study.array.Permutation.PermutationII

import org.junit.Test

class SolutionTest {

    @Test
    fun permuteUnique() {
        val permutationContainer = Solution().permuteUnique(intArrayOf(1,1,2))
        println("permutationContainer = ${permutationContainer}")

        println("Solution().permuteUnique(intArrayOf(1,1,1,2)) = ${Solution().permuteUnique(intArrayOf(1, 1, 1, 2))}")

    }

}