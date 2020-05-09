package study.list.single.RemoveDuplicatesFromLinkedList

import study.list.single.toArrayList
import study.list.single.toLinkedList
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

        var list = arrayListOf("aa", "bb", "cc")
        list.mapIndexed { index, string ->
            println("index = ${index}")
            println("string = ${string}")
        }
    }

    @Test
    fun test() {
        val flutter = "4234162351623134534414424235151542514434155141453331141351145242361516315142344543151343562451416616254142441715525455551523461432513525254341532165324133451441414334132541413413225424541154121123213121221313224154144424632515241541114414143245334254151632515321544144241342455114334244252541415132414144331543415425254252632113415151444555145515414245152541415433155324149551444144241343526424485151335341414414414133333422314631643331451451"
        val ios = "3213334522123221332223333351243342244252244331323521332313221244213124222234341421414431413332413344212223233215421312432443341434345343323132244321452133123313214234233411552141252243335124212134424122333233132533213333242134432243315222432134233216223222313342111221222232122313312222322343212442131242112121124122124213214333212333214531312433443524234333214434124322432243141314522412534312434131454223223421512"

        println("flutter---")
        average(flutter.toCharArray())
        println("ios---")
        average(ios.toCharArray())

    }

    fun average(charArray: CharArray) {
        val intArray = charArray.map { (it - '0') * 10 }
        val average = intArray.average()
        intArray.forEach { println("${it}") }
        println("average = ${average}")
    }
}