package divide_and_conquer

import kotlin.random.Random


var num = 0

/**
 * 求一组数据的有序对个数或者逆序对个数
 */
fun count(intArray: IntArray): Int {
    num = 0
    mergeSortCount(intArray, 0, intArray.size - 1)
    return num
}

fun mergeSortCount(intArray: IntArray, startIndex: Int, endIndex: Int) {
    if (startIndex >= endIndex) {
        return
    }
    val mid = startIndex + (endIndex - startIndex) / 2

    mergeSortCount(intArray, startIndex, mid)
    mergeSortCount(intArray, mid + 1, endIndex)
    merge(intArray, startIndex, mid, endIndex)
}

fun merge(array: IntArray, startIndex: Int, mid: Int, endIndex: Int) {
    var i = startIndex
    var j = mid + 1
    var k = 0
    val tmp = arrayOfNulls<Int>(endIndex - startIndex + 1)
    while (i <= mid && j <= endIndex) {
        if (array[i] <= array[j]) {
            tmp[k++] = array[i++]
        } else {
            num += mid - i + 1
            tmp[k++] = array[j++]
        }
    }
    while (i <= mid) {
        tmp[k++] = array[i++]
    }
    while (j <= endIndex) {
        tmp[k++] = array[j++]
    }
    for (index in 0 until endIndex - startIndex) {
        array[startIndex + index] = tmp[index]!!
    }
}

fun main() {
    count(intArrayOf(2, 4, 3, 1, 5, 6))
    println(num)
}


