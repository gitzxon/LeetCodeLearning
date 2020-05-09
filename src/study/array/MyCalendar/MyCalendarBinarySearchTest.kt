package study.array.MyCalendar

import study.array.MyCalendar.MyCalendarIUseingBinarySearch.MyCalendar
import org.junit.Test
import study.util.DataUtil

class MyCalendarBinarySearchTest {

    @Test
    fun book() {
        val myCalendarBinarySearch = MyCalendar()
        val pairs = DataUtil().parseToPair("[10,20],[50,60],[10,40],[5,15],[5,10],[25,55]").map {
            it.first.toInt() to it.second.toInt()
        }

        val expected = DataUtil().parse("[true,true,true,false,true,true]").map {
            it.toBoolean()
        }

        val output = pairs.map {
            val r = myCalendarBinarySearch.book(it.first, it.second)
            println("r = ${r}")
            r
        }
        println("expected = ${expected}")
        println("output = ${output}")

    }
}