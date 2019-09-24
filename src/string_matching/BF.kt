package string_matching

/*
* BF 算法 是 Brute Force 的缩写，中文叫做暴力匹配算法，也叫朴素匹配算法。
* BF 算法的思想就是检查主串起始位置分别为0、1、2...n-m 且长度为 m 的 n-m+1 字符串，看有没有和模式串相匹配的。
* */
fun bf(main: String, match: String) {
    val matchLength = match.length

    val length = main.length
    for (index in 0 until length) {
        if (index + matchLength > length) {
            break
        }
        val endIndex = index + matchLength
        if (main.substring(index, endIndex) == match) {
            println("startIndex: $index endIndex $endIndex == $match")
            return
        }
    }
    println("string no matching $match")
}

fun main(args: Array<String>) {
    val main = "abcedbgfhkjxxxcjviojwer"
    bf(main, "jwer")
    bf(main, "xcj")
    bf(main, "abc")
    bf(main, "ggg")
}