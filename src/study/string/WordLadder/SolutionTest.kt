package study.string.WordLadder

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {

    @Test
    fun ladderLength() {

//        "hit"3 -> "hot"2 -> "dot"2 -> "dog"1 -> "cog",
        assertEquals(5,
                Solution().ladderLength(
                        "hit",
                        "cog",
                        arrayListOf("hot", "dot", "dog", "lot", "log", "cog")
                )
        )

    }

    @Test
    fun t1() {
        assertEquals(
                0,
                Solution().ladderLength(
                        "hit",
                        "cog",
                        arrayListOf("hot", "dot", "dog", "lot", "log")
                )
        )

    }


    @Test
    fun t2() {
        assertEquals(
                5,
                Solution().ladderLength(
                        "qa",
                        "sq",
                        arrayListOf("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"))
        )
    }
}