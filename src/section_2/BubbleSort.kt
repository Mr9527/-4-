package section_2

/**
 *
 */
class BubbleSort {
    companion object {
        fun sort(array: Array<Double>) {
            array.show()
            for (b in array) {
                var flag = false
                for (i in 0 until array.size - 1) {
                    if (array[i] > array[i + 1]) {
                        array.exch(i, i + 1)
                        array.betterShow(i, i + 1)
                        flag = true
                    }
                }
                if (!flag) break
            }
            array.show()
        }

        @JvmStatic
        fun main(array: Array<String>) {
            BubbleSort.sort(SortCompare.uniformArray())
        }
    }

}