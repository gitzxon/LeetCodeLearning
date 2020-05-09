package study.util

fun main(args: Array<String>) {

//    DataUtil().parse("[10,20],[50,60],[10,40],[5,15],[5,10],[25,55]")
    DataUtil().parseMatrix("""
                    [
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
    """.trimIndent(), 5)
}

class DataUtil {
    fun parseToPair(s: String): List<Pair<String, String>> {
        val split = performParse(s)
        println("split = ${split}")

        val result = split.chunked(2).map { it[0] to it[1]}
        println("result = ${result}")
        return result
    }

    fun parse(s: String): List<String> {
        return performParse(s)
    }

    private fun performParse(s: String): List<String> {
        val split = s.split("[", "]", ",").filter {
            it.isNotEmpty()
        }
        return split
    }

    fun parseMatrix(input: String, colCount: Int): Array<Array<String>> {
        val twoDimenList = input.split("[", "]", ",")
                .filter { it.isNotEmpty() && it != "\n" && it.isNotBlank() }
                .chunked(colCount)

        val result = Array(twoDimenList.size) {
            Array(colCount) { "0" }
        }
        twoDimenList.forEachIndexed { row, list ->
            list.forEachIndexed { col, s ->
                result[row][col] = s
            }
        }
        return result
    }

}