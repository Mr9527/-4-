package section_2

import edu.princeton.cs.introcs.StdDraw
import edu.princeton.cs.introcs.StdOut
import edu.princeton.cs.introcs.StdRandom
import java.awt.Color

abstract class Example {

    abstract fun sort(array: Array<Double?>)

    fun less(a: Double?, b: Double?): Boolean {
        return a!! < b!!
    }

    fun exch(a: Array<Double?>, i: Int, j: Int) {
        val t = a[i]
        a[i] = a[j]
        a[j] = t
    }


    private fun drawRect(i: Int, a: Array<Double?>) {
        StdDraw.filledRectangle(i * 1.0 / a.size, a[i]!! / 2.0, 0.5 / a.size, a[i]!! / 2.0)
    }

    private fun clearRect(i: Int, a: Array<Double?>) {
        val color = StdDraw.getPenColor()
        StdDraw.setPenColor(Color.WHITE)
        StdDraw.filledRectangle(i * 1.0 / a.size, a[i]!! / 2.0, 0.5 / a.size, 1.0)
        StdDraw.setPenColor(color)
    }

    fun show(a: Array<Double?>, paintColor: Color? = null, currentIndex: Int = -1) {
        StdDraw.clear()
        a.forEachIndexed { i, _ ->
            val color = if (i == currentIndex) {
                StdDraw.BOOK_RED
            } else paintColor ?: StdDraw.BLACK
            StdDraw.setPenColor(color)
            drawRect(i, a)
        }
    }

    /**
     * 自己手动“清除”画板 然后更新
     */
    fun betterShow(array: Array<Double?>, before: Int, current: Int) {
        clearRect(before, array)
        clearRect(current, array)
        StdDraw.setPenColor(StdDraw.BLACK)
        drawRect(before, array)
        StdDraw.setPenColor(StdDraw.BOOK_RED)
        drawRect(current, array)
        StdDraw.setPenColor(StdDraw.BLACK)
        drawRect(current, array)
    }

    /**
     * 原地归并
     *
     */
    fun merge(a: Array<Double?>, aux: Array<Double?>, lo: Int, mid: Int, hi: Int) {
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
                    aux[j++]
                }
            //右半边用尽
                j > hi -> {
                    changedIndex = i
                    aux[i++]
                }
            //右半边的当前元素小于左半边的元素，取右半边的元素
                less(aux[j], aux[i]) -> {
                    changedIndex = j
                    aux[j++]
                }
            //右半边的当前元素大于左半边元素，取左半边元素
                else -> {
                    changedIndex = i
                    aux[i++]
                }
            }
            betterShow(a, changedIndex, k)
        }
    }

    fun isSorted(a: Array<Double?>): Boolean {
        return (1 until a.size).none { less(a[it]!!, a[it - 1]!!) }
    }

    /**
     * 找到中间点，并确保左边的数比 J 小，右边的数比 J 大
     */
    fun partition(a: Array<Double?>, lo: Int, hi: Int): Int {
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
            exch(a, i, j)
            betterShow(a, j, i)
        }
        exch(a, lo, j)
        betterShow(a, j, lo)

        return j
    }

    fun testArray(size: Int = 100): Array<Double?> {
        val a = arrayOfNulls<Double>(size)
        for (i in a.indices) {
            a[i] = StdRandom.uniform()
        }
        return a
    }

    fun printArray(a: Array<Double?>) {
        a.forEachIndexed { i, item ->
            StdOut.print(" $item")
        }
        StdOut.println()
    }

    companion object {

        @JvmStatic
        fun main(array: Array<String>) {

        }
    }
}
