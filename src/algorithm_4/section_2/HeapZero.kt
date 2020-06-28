package algorithm_4.section_2

/**
 * @author chenzhaojun
 * @date   2018/4/12
 * @description
 */
class HeapZero {

    companion object {
        fun sort(a: Array<Double>) {
            a.show()
            var i: Int = a.size / 2 - 1
            while (i >= 0) {// 构建一个大顶堆
                sink(a, i, a.size - 1)
                i--
            }
            i = a.size - 1
            var beforeIndex = 0
            while (i >= 0) {// 将堆顶记录和当前未经排序子序列的最后一个记录交换
                a.exch(0, i)
                a.betterShow(beforeIndex, i)
                sink(a, 0, i - 1)// 将a中前i-1个记录重新调整为大顶堆
                beforeIndex = i
                i--
            }
            print("array is Sorted ?  ${a.isSorted()}")
            a.printArray()
        }

        private fun sink(array: Array<Double>, k: Int, len: Int) {
            val tmp: Double = array[k]
            var j: Int = 2 * k
            var i = k
            while (j < len) {
                if (j < len && less(array[j], array[j + 1])) {
                    j++
                }
                if (tmp >= array[j]) {
                    break
                }
                array[i] = array[j]
                array.betterShow(i, j)
                i = j
                j *= 2
            }
            array[i] = tmp
            array.betterShow(i, k)
        }

        @JvmStatic
        fun main(array: Array<String>) {
            HeapZero.sort(SortCompare.uniformArray())
        }
    }
}