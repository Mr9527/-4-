package section_2

import edu.princeton.cs.introcs.StdDraw

/**
 * @author chenzhaojun
 * @date   2018/4/13
 * @description 快速排序三取样切分——使用数组的以小部分元素的中位数来切分数组。这样数组得到的切分效果更好，但代价是需要计算中位数。
 * 三取样区分是为了优化快速排序在二分分区的时候因为数据原本就是有序或者接近有序的，分区可能每次分区点都选择最后一个数据，在随机分
 * 布的数值排序中这样排序并不会比普通的快速排序快，甚至会慢很多
 */
class Quick3way {

    companion object {
        fun sort(array: Array<Double>) {
            array.show()
            sort(array, 0, array.size - 1)
            array.show(StdDraw.GREEN)
            val msg = if (array.isSorted()) "is" else "not"
            print("this array $msg sorted ")
        }

        private fun sort(array: Array<Double>, lo: Int, hi: Int) {
            if (hi <= lo) return
            var lt = lo
            var i = lo + 1
            var gt = hi
            val v = array[lo]

            while (i <= gt) {
                val cmp: Int = array[i].compareTo(v)
                when {
                    cmp < 0 -> {
                        array.betterShow(lt, i)
                        array.exch(lt++, i++)
                    }
                    cmp > 0 -> {
                        array.betterShow(i, gt)
                        array.exch(i, gt--)
                    }
                    else -> i++
                }
            }
            sort(array, lo, lt - 1)
            sort(array, lt + 1, hi)
        }

        @JvmStatic
        fun main(str: Array<String>) {
            Quick3way.sort(SortCompare.sameArray(2000))
        }
    }
}