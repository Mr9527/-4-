package section_2

import edu.princeton.cs.introcs.StdDraw

/**
 * 自顶向下——从顶部开始归并两个大数组，但最后归并的数组都十分的小
 * 自底向上——先归并微型数组，再归并大数组
 * 归并排序——自低向上排序
 * {@link Merge} 自顶向下排序
 */
class MergeBU : Example() {
    override fun sort(a: Array<Double?>) {
        show(a)
        val n = a.size
        val aux: Array<Double?> = arrayOfNulls(a.size)
        //写个双重 for 循环真受罪
        var sz = 1
        while (sz < n) {
            var lo = 0
            while (lo < n - sz) {
                merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1))
                lo += sz + sz
            }
            sz += sz
        }
        show(a, StdDraw.GREEN)
    }

    companion object {
        @JvmStatic
        fun main(str: Array<String>) {
            SortCompare.match("Merge", "MergeBU", 50, 2)
        }

    }
}