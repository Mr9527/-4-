package algorithm_4.section_2

import edu.princeton.cs.introcs.StdDraw

/**
 * 选择排序：首先找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置（如果第一个元素是最小元素那么就和它自己交换）
 * 再次，在剩下的元素中找到最小的元素，将它于数组的第二个元素交换位置。如此往复，直到将整个数组排序。
 * 特性：
 *  - 对于长度为 N 的数组，选择排序大约需要 N^2/2 次比较和 N 次交换
 *  - 运行时间和输入无关
 *  - 数据移动是最少的
 *
 *
 */
class Selection {

    companion object {

        fun sort(array: Array<Double>) {
            array.show()
            val n = array.size
            for (i in 0 until n) {
                var min = i
                (i + 1 until n).asSequence().filter { less(array[it], array[min]) }.forEach { min = it }
                array.exch(i, min)
                array.betterShow(i, min)
            }
            array.show(StdDraw.GREEN)
        }


        @JvmStatic
        fun main(array: Array<String>) {
            Selection.sort(SortCompare.uniformArray())
        }
    }

}