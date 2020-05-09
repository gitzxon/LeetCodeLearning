package study.list.single.AddTwoNumbersII

import study.list.single.print
import study.list.single.toArrayList
import study.list.single.toLinkedList
import org.junit.Test

import org.junit.Assert.*
import java.util.*

class SolutionTest {

    @Test
    fun reverse() {
        reverseHelper(
                intArrayOf(5,4,3,2,1)
        )
        reverseHelper(
                intArrayOf(1,2,3,4,5,6,7,8,9,0)
        )

    }

    @Test
    fun addTwoNumbers() {
        helperAdd(
                7243,
                564
        )

        helperAdd(
                0,
                73
        )
    }

    private fun helperAdd(a: Int, b: Int) {
        val sum = a + b

        val arrayA = a.toString().toCharArray().map { it -> it - '0' }.toIntArray()
        val arrayB = b.toString().toCharArray().map { it -> it - '0' }.toIntArray()
        println("Arrays.toString(arrayA) = ${Arrays.toString(arrayA)}")
        println("Arrays.toString(arrayB) = ${Arrays.toString(arrayB)}")
        val headA = arrayA.toLinkedList()
        val headB = arrayB.toLinkedList()
        val result = Solution().addTwoNumbers(headA, headB)
        val resultArray = result.toArrayList().toIntArray()
        println("resultArray = ${resultArray.print()}")


        val resultInt = Integer.parseInt(resultArray.joinToString(separator = "") { i -> i.toString() })
        println("resultInt = ${resultInt}")
    }

    private fun reverseHelper(input: IntArray) {

        val expected = input.reversedArray()

        val head = input.toLinkedList()
        assertArrayEquals(
                expected,
                Solution.reverse(head).toArrayList().toIntArray()
        )
    }
}