package algorithm_4.section_2

import edu.princeton.cs.introcs.StdDraw
import edu.princeton.cs.introcs.StdRandom

/**
 * 快速排序是一种分支的排序算法。它将一个数组分成两个数组，将两个部分独立排序。
 * 快速排序和归并排序是互补的：
 * 归并排序将数组分成两个子数组分别排序，并将有序的子数组归并已将真个数组排序；
 * 而快速排序的排列方式是当两个数组有序时，整个数组就自然有序了
 */
class Quick {


    companion object {

        fun sort(array: Array<Double>) {
            array.show()
            StdRandom.shuffle(array)
            array.show()
            sort(array, 0, array.size - 1)
            array.show(StdDraw.GREEN)
            val msg = if (array.isSorted()) "is" else "not"
            print("this array $msg sorted ")
        }

        private fun sort(array: Array<Double>, lo: Int, hi: Int) {
            if (hi <= lo) return
            val j = partition(array, lo, hi)
            sort(array, lo, j - 1)
            sort(array, j + 1, hi)
        }

        /**
         * 找到中间点，并确保左边的数比 J 小，右边的数比 J 大
         */
        private fun partition(a: Array<Double>, lo: Int, hi: Int): Int {
            //将数组切分成a[lo..i-1,a[i],a[i+1..hi]]
            var i = lo
            var j = hi + 1
            val v = a[lo]
            while (true) {
                //扫描左右交换元素
                while (less(a[++i], v)) {
                    //可以打乱数组的时候找到一个最大值放置在最后边当作哨兵，这样就不需要右边的边界检查
                    if (i == hi) break
                }
                while (less(v, a[--j])) {
                }
                if (i >= j) break
                a.exch(i, j)
                a.betterShow(j, i)
            }
            a.exch(lo, j)
            a.betterShow(j, lo)

            return j
        }

        @JvmStatic
        fun main(str: Array<String>) {
//            SortCompare.match("Quick", "MergeBU", 50, 2)
            Quick.sort(SortCompare.sameArray(2000))
        }
    }
}