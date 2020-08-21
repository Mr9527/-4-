package Leetcode

import java.lang.StringBuilder
import kotlin.math.max
import kotlin.test.assertEquals



fun addBinary(a: String, b: String): String {
    var result = StringBuilder();
    val length = (if (a.length > b.length) a.length else b.length)
    val aStack = a.toCharArray()
    val bStack = b.toCharArray()
    var carry = 0
    for (i in length - 1 downTo 0) {
        carry += if (i < aStack.size) aStack[i] - '0' else 0
        carry += if (i < bStack.size) bStack[i] - '0' else 0
        result.append(carry % 2)
        carry /= 2
    }
    if (carry > 0) {
        result.append(0)
    }
    return result.reverse().toString()
}
