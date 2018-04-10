package section_2

import edu.princeton.cs.introcs.StdRandom

/**
 * 快速排序是一种分支的排序算法。它将一个数组分成两个数组，将两个部分独立排序。
 * 快速排序和归并排序是互补的：
 * 归并排序将数组分成两个子数组分别排序，并将有序的子数组归并已将真个数组排序；
 * 而快速排序的排列方式是当两个数组有序时，整个数组就自然有序了
 */
class Quick : Example() {

    override fun sort(array: Array<Double?>) {
        StdRandom.shuffle(array)
        sort(array, 0, array.size - 1)
    }

    fun sort(array: Array<Double?>, lo: Int, hi: Int) {
        if (hi <= lo) return

    }
}