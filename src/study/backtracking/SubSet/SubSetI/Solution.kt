package study.backtracking.SubSet.SubSetI

import java.util.*
import kotlin.collections.ArrayList

class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        Arrays.sort(nums)
        return helper(nums, ArrayList(), ArrayList(), 0)
    }

    private fun helper(nums:IntArray, resultContainer: MutableList<MutableList<Int>>, currentList: MutableList<Int>, startIndex: Int): List<List<Int>> {

        resultContainer.add(ArrayList(currentList))

        if (startIndex >= nums.size) {
            return resultContainer
        }

        for (i in startIndex until nums.size) {
            currentList.add(nums[i])
            helper(nums, resultContainer, currentList, i + 1)
            currentList.removeAt(currentList.size - 1)
        }

        return resultContainer
    }
}