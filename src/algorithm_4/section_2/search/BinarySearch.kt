package algorithm_4.section_2.search

/**
 * 二分查找针对的是一个有序的数据集合，查找的思想类似于分治思想。每次都通过更区间的中间元素对比，将待查找的区间缩小为之前一半，
 * 直到找到要查找的元素，或区间被缩小为 0
 * 它的时间复杂度为 O(longN)
 */
object BinarySearch {

    /**
     * 简单的二分查找——循环实现
     */
    fun searchList(array: Array<Double>, value: Double): Int {
        var low = 0
        var high = array.size - 1

        while (low <= high) {
            val mid = low + (high - low) / 2
            when {
                array[mid] == value -> return mid
                array[mid] < value -> low = mid + 1
                else -> high = mid - 1
            }
        }
        return -1
    }

    /**
     * 简单的二分查找——递归实现
     */
    fun searchInternally(array: Array<Double>, value: Double, low: Int, high: Int): Int {
        if (low > high) return -1
        val mid = low + (high - low) / 2
        return when {
            array[mid] == value -> mid
            array[mid] < value -> searchInternally(array, value, mid + 1, high)
            else -> searchInternally(array, value, low, mid - 1)
        }
    }

    /**
     * 二分查找变体——查找数组中第一个等于 value 的值，与此类相同的还有查找查找最后一个等于  value 的值、查找第一个小于 value 的
     * 值 等等
     */
    fun searchInternallyByFirst(array: Array<Double>, value: Double, low: Int, high: Int): Int {
        if (low > high) return -1
        val mid = low + (high - low) / 2
        return when {
            array[mid] < value -> searchInternallyByFirst(array, value, mid + 1, high)
            array[mid] > value -> searchInternallyByFirst(array, value, low, mid - 1)
            else -> if (mid == 0 || array[mid - 1] != value) mid else searchInternallyByFirst(
                array,
                value,
                low,
                mid - 1
            )
        }
    }


    fun sort(array: Array<Double>, value: Double): Int {
        var line = 0
        for ((index, data) in array.withIndex()) {
            if (data > array[index + 1]) {
                line = index
                break
            }
        }
        return if (value <= array[array.size - 1]) {
            searchInternally(array, value, line - 1, array.size - 1)
        } else {
            searchInternally(array, value, 0, line)
        }
    }


    @JvmStatic
    fun main(args: Array<String>) {
        val array = arrayOf(1.0, 2.0, 3.0, 4.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 23.0)
        var index = searchList(array, 10.0)
        println(index)
        index = searchInternally(array, 10.0, 0, array.size - 1)
        println(index)

        val firstIndex = searchInternallyByFirst(
            arrayOf(1.0, 2.0, 3.0, 4.0, 6.0, 7.0, 11.0, 11.0, 11.0, 11.0, 23.0),
            11.0,
            0,
            array.size - 1
        )
        println(firstIndex)

        println(sort(arrayOf(4.0, 5.0, 6.0, 7.0, 1.0, 2.0, 3.0), 7.0))
    }
}