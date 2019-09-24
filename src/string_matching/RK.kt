package string_matching


/*
* RK 算法全 Rabin_Karp 算法，是由它的两名发明者命名的。
* RK 的算法思路：通过特定的哈希算法对主串中的 n-m+1 个子串分别求哈希值，然后逐个与模式串的哈希值比较大小。如果某个子串的哈希值
* 与模式串相等，那就说明对应的子串和模式串匹配了，如果数据量较大存在哈希冲突的问题，我们还可以继续比较元数据。因为哈希值只是一个
* 数字，数字之间比较是否相等是非常快速的，所以模式串和子串比较的效率就提高了。
*
* 不过这也同样比较考验哈希算法的设计了，如果哈希算法计算子串哈希值效率低下，就会影响整体算法的效率
*
* 我们可以假设要匹配的字符集只包含 K 个字符，我么可以用一个 k 进制数来表示一个字符串，这个 K 进制转化成十进制数，作为子串的哈希值
*
* */
fun rk(main: String, match: String) {
    val matchLength = match.length
    val matchHash = match.easyHash()

    val length = main.length
    for (index in 0 until length) {
        if (index + matchLength > length) {
            break
        }
        val endIndex = index + matchLength
        val fragment = main.substring(index, endIndex)
        val fragmentHash = fragment.easyHash()
        if (fragmentHash == matchHash && fragment == match) {
            println("startIndex: $index endIndex $endIndex == $match")
            return
        }
    }
    println("string no matching $match")
}

fun String.easyHash(): Int {
    var hash: Int = 0;
    val len = length
    if (len > 0) {
        for (i in 0 until len) {
            hash += when (get(i)) {
                'a' -> 0 * 5
                'b' -> 1 * 5
                'c' -> 2 * 5
                'd' -> 3 * 5
                'e' -> 4 * 5
                else -> 0
            }
        }
    }
    return hash
}


fun main() {
    val main = "acadbedbabcdbec"
    rk(main,"bec")
}