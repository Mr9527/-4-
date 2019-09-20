package tree

import edu.princeton.cs.introcs.StdRandom
import section_2.*

/**
 * 堆排序 下标从 1 开始
 *
 */
class Heap {

    companion object {
        fun sort(array: Array<Double>) {
            array.show()
            var size = array.size - 1
            //将大的数排序到最前面，小的的数下沉
            var k = size / 2
            while (k >= 1) {
                sink(array, k, size - 1)
                k--
            }
            // 一个数来辅助记录上次修改的位置
            var beforeIndex = 0
            while (size > 1) {
                //每次交换收尾和最后一位，首位递减
                array.exch(1, size--)
                array.betterShow(beforeIndex, size + 1)
                //筛选1-size中最大的排列到首位
                sink(array, 1, size)
                beforeIndex = size
            }
            print("array is Sorted ?  ${array.isSorted()}")
            array.printArray()
        }

        /**
         * @param array 排序数组
         *
         */
        private fun sink(array: Array<Double>, k: Int, length: Int) {
            var i = k
            while (2 * i <= length) {
                var j = 2 * i
                if (j < length && less(array[j], array[j + 1])) {
                    j++
                }
                //如果上一次交换的结点大于这次的结点
                if (!less(array[i], array[j])) {
                    break
                }
                array.exch(i, j)
                array.betterShow(i, j)
                i = j
            }
        }


        @JvmStatic
        fun main(array: Array<String>) {
            sort(Array(500, { it -> if (it == 0) 0.0 else StdRandom.uniform() }))
        }
    }

}