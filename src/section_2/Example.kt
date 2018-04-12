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
     * 数组是否有序
     */
    fun isSorted(a: Array<Double?>): Boolean {
        return (1 until a.size).none { less(a[it]!!, a[it - 1]!!) }
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
