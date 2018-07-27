package list.single.RemoveDuplicatesFromLinkedList

import list.single.toArrayList
import list.single.toLinkedList
import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun deleteDuplicates() {

        assertArrayEquals(
                intArrayOf(1, 3),
                Solution().deleteDuplicates(
                        intArrayOf(1, 2, 2, 2, 3).toLinkedList()
                ).toArrayList().toIntArray()
        )

        assertArrayEquals(
                intArrayOf(2, 3),
                Solution().deleteDuplicates(
                        intArrayOf(1, 1, 1, 2, 3).toLinkedList()
                ).toArrayList().toIntArray()
        )

        assertArrayEquals(
                intArrayOf(1, 2, 5),
                Solution().deleteDuplicates(
                        intArrayOf(1, 2, 3, 3, 4, 4, 5).toLinkedList()
                ).toArrayList().toIntArray()
        )

        assertArrayEquals(
                intArrayOf(),
                Solution().deleteDuplicates(
                        intArrayOf(1, 1).toLinkedList()
                ).toArrayList().toIntArray()
        )
    }
}