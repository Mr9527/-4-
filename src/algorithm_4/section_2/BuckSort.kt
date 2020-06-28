package algorithm_4.section_2

import java.util.*
import kotlin.collections.ArrayList

/**
 * 桶排序的核心思想是将要排序的数据分到几个有序的捅里，每个桶里的数据单独进行排序。桶内排完序之后，再把每个桶里的数据按照顺序
 * 依次取出，组成的序列就是有序的了。
 *
 * 桶排序的复杂度是 O(n) : 如果排序的数据有 n 个，我们把它均匀的分到 m 个通内，每个桶里就有 k=n/m 个元素。每个桶内部使用快速排序
 * 时间复杂度为 O(k*logK)。M 个桶排序时间复杂度就是 O(m*k*logK)，因为 k=n/m ，所以整个桶排序的时间复杂度就是O(n*log(n/m))，当
 * 桶的个数非常接近 n 的时候， log(n/m) 就是一个非常小的常量，这个时候桶排序的时间复杂度接近于 O(n)
 *
 * 桶排序的复杂度虽然是 O(n) 但是它非常依赖于桶的合理划分,首先，需要排序的数据很容易就划分为 m 个桶，并且，桶与桶之间有着天然的大小顺序
 * 这个每个桶排序完之后，桶与桶之间的数据不再需要进行排序。其次，数据在各个桶之间的分部是比较均匀的。如果数据经过桶的划分之后，有
 * 些桶的数据非常多，有些非常少，很不平均，那桶内数据排序的时间复杂度就不再是常量级了，极端情况下会退化为 O(nlogn) 的排序算法
 *
 * 桶排序比较适用于外部排序中。所谓的外部排序就是数据存储在外部磁盘中，数据量比较大，内存有限，无法将数据全部加载到内存中，
 * 我们可以将数据划分为 M 个桶，并将数据均分到这 m 个桶中，在内存中依次对每个桶进行快排排序，最后只需要按照编号，从小到大将所有桶
 * 加载到内存中写到一个文件中，那这个文件中的数据就已经排序好了。
 */
object BuckSort {

    @JvmStatic
    fun main(args: Array<String>) {
        val arr = arrayOf(0.12, 2.2, 8.8, 7.6, 7.2, 6.3, 9.0, 1.6, 5.6, 2.4)
        sort(arr)
        SortCompare.printArray(arr)
    }


    fun sort(array: Array<Double>) {
        val buckets = ArrayList<LinkedList<Double>>()
        // 桶
        for (index in 1..10) {
            buckets.add(LinkedList())
        }
        for (data in array) {
            val index = getBuckIndex(data)
            insertSort(buckets[index], data)
        }
        var index = 0
        for (data in buckets) {
            for (element in data) {
                array[index++] = element
            }
        }

    }

    /**
     * 计算元素应该放在第几个桶内
     *
     */
    private fun getBuckIndex(data: Double): Int {
        return data.toInt()
    }

    /**
     * 将数据放入桶，这一步骤我们可以使用插入排序来保证放入的时候就保证有序性，或者在放入后对桶进行插入排序
     */
    private fun insertSort(list: LinkedList<Double>, data: Double) {
        val iterator = list.listIterator()
        var insertFlag = false
        while (iterator.hasNext()) {
            if (data <= iterator.next()) {
                iterator.previous()
                iterator.add(data)
                insertFlag = true
                break
            }
        }
        if (!insertFlag) {
            list.add(data)
        }
    }


}