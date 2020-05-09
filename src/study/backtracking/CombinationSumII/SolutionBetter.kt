package study.backtracking.CombinationSumII

import java.util.*

class SolutionBetter {

    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {

        println("====================")

        Arrays.sort(candidates)
        return helper(ArrayList(), candidates, target, ArrayList(), 0)
    }

    fun helper(resultContainer: MutableList<List<Int>>, candidates: IntArray, target: Int, curNums: MutableList<Int>, curIndex: Int): List<List<Int>> {
        println("---------helper called: -----------")
        println("curNums = ${curNums}")
        println("curIndex = ${curIndex}")
        println("target = ${target}")

        if (target == 0) {
            val aResult = ArrayList<Int>()
            aResult.addAll(curNums)
            resultContainer.add(aResult)
            return resultContainer
        } else if (target < 0) {
            return resultContainer
        }

        for (i in curIndex until candidates.size) {
            if (i > curIndex && candidates[i] == candidates[i - 1]) {
                continue
            }

            val num = candidates[i]
            curNums.add(num)
            helper(resultContainer, candidates, target - num, curNums, i + 1)
            curNums.removeAt(curNums.size - 1)
        }

        return resultContainer
    }

}
