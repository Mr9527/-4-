package section_2.priority_queue

/**
 * @author chenzhaojun
 * @date   2018/4/12
 * @description 基于堆的完全二叉树表示的一个优先队列
 * 如何用数组实现一个完全二叉树？
 *  - 不使用数组的第一个位置，使其更符合数学性质便于计算
 *  - 按照层级顺序放入数组中 根节点是 1 那么子结点就在 2、3 子节点的结点点在4、5、6 和 7。即位置 K 的结点的父结点的位置为[k/2]，那么
 *  它的两个子节点为 2k 和 2k+1
 *  - 处理新插入结点的上浮
 *  - 处理旧结点的下沉
 *
 *  用数组的实现二叉树非常查询起来非常高效，可以有效的减少比较次数，通过数组的下标我们就可以算出父节点所在的位置。
 *  但是当树倾斜不构成完全二叉树后则非常的浪费空间。
 */
class MaxPriorityQueue<T : Comparable<T>>(initSize: Int = 0) {

    @Suppress("UNCHECKED_CAST")
    private var queue: Array<T?> = arrayOfNulls<Any>(initSize) as Array<T?>

    var index: Int = 0

    fun insert(value: T) {
        queue[++index] = value
        swim(index)
    }

    fun deleteMax(): T {
        val max = queue[1]
        exch(1, index--)
        queue[index + 1] = null
        sink(1)
        return max!!
    }

    fun isEmpty() = index == 0

    fun size() = index

    private fun exch(i: Int, j: Int) {
        val t = queue[i]
        queue[i] = queue[j]
        queue[j] = t
    }

    private fun swim(k: Int) {
        var i = k
        while (i > 1 && less(i / 2, i)) {
            exch(i / 2, i)
            i /= 2
        }
    }

    private fun sink(k: Int) {
        var i = k
        while (2 * i <= index) {
            var j = 2 * i
            if (j < index && less(j, j + 1)) {
                j++
            }
            if (!less(i, j)) {
                break
            }
            exch(i, j)
            i = j
        }
    }

    private fun less(i: Int, j: Int): Boolean {
        return queue[i]!! < queue[j]!!
    }
}