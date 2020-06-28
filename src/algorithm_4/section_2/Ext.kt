package algorithm_4.section_2

import edu.princeton.cs.introcs.StdDraw
import edu.princeton.cs.introcs.StdOut
import java.awt.Color
import java.util.*

/**
 * @author chenzhaojun
 * @date   2018/4/12
 * @description
 */

fun <T : Comparable<T>> Array<T>.isSorted(): Boolean {
    return (1 until this.size).none { less(this[it], this[it - 1]) }
}

fun Array<Double>.show(paintColor: Color? = null, currentIndex: Int = -1) {
    println(Date())
    StdDraw.clear()
    this.forEachIndexed { i, _ ->
        val color = if (i == currentIndex) {
            StdDraw.BOOK_RED
        } else paintColor ?: StdDraw.BLACK
        StdDraw.setPenColor(color)
        drawRect(i, this)
    }
}

fun Array<Double>.betterShow(before: Int, current: Int) {
    clearRect(before, this)
    clearRect(current, this)
    StdDraw.setPenColor(StdDraw.BLACK)
    drawRect(before, this)
    StdDraw.setPenColor(StdDraw.BOOK_RED)
    drawRect(current, this)
    StdDraw.setPenColor(StdDraw.BLACK)
    drawRect(current, this)
}

fun <T> Array<T>.exch(i: Int, j: Int) {
    val t = this[i]
    this[i] = this[j]
    this[j] = t
}

fun <T> Array<T>.printArray() {
    StdOut.println()
    this.forEach { StdOut.print(" $it") }.run { StdOut.println() }
}

fun <T : Comparable<T>> less(a: T, b: T): Boolean {
    return a < b
}


fun drawRect(i: Int, a: Array<Double>) {
    StdDraw.filledRectangle(i * 1.0 / a.size, a[i] / 2.0, 0.5 / a.size, a[i] / 2.0)
}

fun clearRect(i: Int, a: Array<Double>) {
    val color = StdDraw.getPenColor()
    StdDraw.setPenColor(Color.WHITE)
    StdDraw.filledRectangle(i * 1.0 / a.size, a[i] / 2.0, 0.5 / a.size, 1.0)
    StdDraw.setPenColor(color)
}