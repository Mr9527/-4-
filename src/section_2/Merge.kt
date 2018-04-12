package section_2

import edu.princeton.cs.introcs.StdDraw

/**
 * 归并既将两个有序的数组归并成一个更大的有序数组
 * 优点：能保证任意长度为 N 的数组排序所需时间和 NlgN 成正比；
 * 缺点：它所需的额外空间和 N 成正比
 * 归并排序是一种渐进最优的基于比较的排序算法
 * 归并排序在最坏情况下的比较次数和任意基于比较的排序算法所需的最少比较次数都是 ~NLgN
 *
 * 归并排序——自顶向下排序
 * 基于原地归并 Merge 的抽象实现了另一种递归归并，这也是应用高效算法设计中分治思想的典型应用
 * 对数组 array[lo ... hi] 进行排序，先将他们分为 array[lo ... mid]和 array[mid+1 ... hi] 然后对它们通过递归调用单独排序
 * 最后将有序的子数组归并为最终的排序结果
 *
 * {@link MergeBu} 自低向上排序
 */
class Merge {


    companion object {

        fun sort(a: Array<Double>) {
            val aux: Array<Double?> = arrayOfNulls(a.size)
            a.show()
            sort(a, aux, 0, a.size - 1)
            a.show(StdDraw.GREEN)
        }

        private fun sort(array: Array<Double>, copyArray: Array<Double?>, lo: Int, hi: Int) {
            if (hi <= lo) return
            val mid = lo + (hi - lo) / 2
            sort(array, copyArray, lo, mid)
            sort(array, copyArray, mid + 1, hi)
            merge(array, copyArray, lo, mid, hi)
        }

        private fun merge(a: Array<Double>, aux: Array<Double?>, lo: Int, mid: Int, hi: Int) {
            var i = lo
            var j = mid + 1
            var changedIndex: Int
            for (k in lo..hi) {
                aux[k] = a[k]
            }
            for (k in lo..hi) {
                a[k] = when {
                //左半边用尽
                    i > mid -> {
                        changedIndex = j
                        aux[j++]!!
                    }
                //右半边用尽
                    j > hi -> {
                        changedIndex = i
                        aux[i++]!!
                    }
                //右半边的当前元素小于左半边的元素，取右半边的元素
                    less(aux[j]!!, aux[i]!!) -> {
                        changedIndex = j
                        aux[j++]!!
                    }
                //右半边的当前元素大于左半边元素，取左半边元素
                    else -> {
                        changedIndex = i
                        aux[i++]!!
                    }
                }
                a.betterShow(changedIndex, k)
            }
        }

        @JvmStatic
        fun main(array: Array<String>) {
            Merge.sort(SortCompare.uniformArray())
        }
    }

}