package section_2

import edu.princeton.cs.introcs.StdOut
import edu.princeton.cs.introcs.StdRandom

class Shell : Example() {

    override fun sort(array: Array<Double?>) {
        val n = array.size
        var h = 1;
        while (h < n / 3) {
            h = h * 3 + 1 //1,4,13,40,121,364,1093
        }
        while (h >= 1) {
            for (i in h until n) {
                //将数组变成h有序列
                var j = i
                while (j >= h && less(array[j], array[j - h])) {
                    exch(array, j, j - h)
                    betterShow(array,j,j-h)
                    j -= h;
                }
            }
            h /= 3
        }
        show(array)
    }

    companion object {
        @JvmStatic
        fun main(array: Array<String>) {
            val sort = Shell()
            val a = arrayOfNulls<Double>(50)
            for (i in a.indices) {
                a[i] = StdRandom.uniform()
            }
            sort.sort(a)
        }
    }
}

