package string_matching

import edu.princeton.cs.introcs.StdDraw
import java.awt.Color
import kotlin.math.max

/*
* BM 全称 Boyer-Moore 算法，它是一种非常高效的字符串匹配算法。
* BM 算法思路：我们把模式串和主串的匹配过程，看作模式串在主串中不停的向后滑动。当遇到不匹配的算法的时候，BF 算法和 RK 是将模式串向后滑动一位，
* 然后从模式串的第一个字符串开始重新匹配。
 */
fun bm(main: String, match: String): Int {
    val bc = generateBC(match)
    val suffix = arrayOfNulls<Int>(match.length)
    val prefix = arrayOfNulls<Boolean>(match.length)
    generateGS(match, suffix, prefix)
    var i = 0;
    while (i < main.length - match.length) {
        var j = match.length - 1
        while (j >= 0) {
            if (main[i + j] != match[j]) {
                break
            }
            j--
        }
        // 匹配成功
        if (j < 0) {
            return i
        }
        // 如果匹配不成功，则将下标向后移动
        // 当发生不配的时候，我们把坏字符对应的模式串字符下标记做 j
        // 我们把这个坏字符在模式串的中下标记做  bc[main[i + j]
        // 模式串往后的移动位置就等于 j -bc[main[i+j]]
        // 该值可能为负数，导致模式串向前滑动，所以这时候还需要“好后缀”规则匹配
        val x = (j - bc[main[i + j].toInt()])
        var y = 0
        if (j < match.length - 1) {
            y = moveByGs(j, match, suffix, prefix)
        }
        i += max(x, y)
        StdDraw.text(i * 1.0 / main.length + 0.01, 0.75, "▲");
        StdDraw.text(i * 1.0 / main.length + 0.01, 0.70, """${max(x, y)}""");
    }
    return -1
}

fun moveByGs(j: Int, match: String, suffix: Array<Int?>, prefix: Array<Boolean?>): Int {
    val k = match.length - 1 - j//好后缀长度
    if (suffix[k]!! != -1) {
        return j - suffix[k]!! + 1
    }
    var r = j + 2
    while (r <= match.length - 1) {
        if (prefix[match.length - r]!!) {
            return r
        }
        r++
    }
    return match.length
}

const val SIZE = 256
/**
 *  在 BM 算法的坏字符规则中，我们需要经常使用模式串用作遍历查找。这一部分我们可以用散列表将模式串的每个字符及其下标都存到散列表中
 *  这样就可以快速找到坏字符串的位置下标了
 */
fun generateBC(match: String): IntArray {
    val matchArray = IntArray(SIZE) { -1 }
    for (i in 0 until match.length) {
        val toInt = match[i].toInt()
        matchArray[toInt] = i
    }
    return matchArray
}

fun generateGS(match: String, suffix: Array<Int?>, prefix: Array<Boolean?>) {
    for (i in 0 until match.length) {
        suffix[i] = -1
        prefix[i] = false
    }
    var i = 0
    while (i < match.length - 1) {
        var j = i
        var k = 0
        while (j >= 0 && match[j] == match[match.length - 1 - k]) {
            --j
            ++k
            suffix[k] = j + 1
        }
        if (j == -1) prefix[k] = true // 如果公共后缀子串也是模式串的前缀子串
        i++
    }
}

fun main() {
    val main = "abcsdfsoighwasdbvcfsdfssabavvvababdsfsdzxw"
    StdDraw.setPenColor(Color.BLACK)
    val mainArray = main.toCharArray()
    mainArray.forEachIndexed { i, c ->
        StdDraw.text(i * 1.0 / mainArray.size + 0.01, 0.8, c.toString())
    }
    val bm =
        bm(main, "ssab")
    println(bm)
}