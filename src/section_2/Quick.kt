package section_2

import edu.princeton.cs.introcs.StdDraw

/**
 * 快速排序是一种分支的排序算法。它将一个数组分成两个数组，将两个部分独立排序。
 * 快速排序和归并排序是互补的：
 * 归并排序将数组分成两个子数组分别排序，并将有序的子数组归并已将真个数组排序；
 * 而快速排序的排列方式是当两个数组有序时，整个数组就自然有序了
 */
class Quick : Example() {

    override fun sort(array: Array<Double?>) {
        show(array)
//        StdRandom.shuffle(array)
        show(array)
        sort(array, 0, array.size - 1)
        show(array, StdDraw.GREEN)
        val msg = if (isSorted(array)) "is" else "not"
        print("this array $msg sorted ")
    }

    fun sort(array: Array<Double?>, lo: Int, hi: Int) {
        if (hi <= lo) return
        val j = partition(array, lo, hi)
        sort(array, lo, j - 1)
        sort(array, j + 1, hi)
    }

    companion object {
        @JvmStatic
        fun main(str: Array<String>) {
//            SortCompare.match("Quick", "MergeBU", 50, 2)
            val quick = Quick()
            quick.sort(arrayOf(11.0, 18.0, 1.0, 20.0, 5.0, 12.0, 5.0, 16.0, 21.0, 9.0, 14.0, 17.0, 3.0, 24.0, 15.0, 19.0))
        }
    }
}