package section_2

/**
 *  希尔排序 ：是一种基于插入排序的算法。和插入排序只能交换相邻的元素同，希尔排序为了加快速度改进了插入排序，把数组分成若干份
 *  交换小区间内不相邻的元素以对数组的局部进行排序，并最终用插入排序将局部有序的数组排序（使用图表可以很清晰的看出来）
 */
class Shell : Example() {

    override fun sort(array: Array<Double?>) {
        val n = array.size
        var h = 1
        while (h < n / 3) {
            h = h * 3 + 1 //1,4,13,40,121,364,1093
        }
        while (h >= 1) {
            for (i in h until n) {
                //将数组变成h有序列
                var j = i
                while (j >= h && less(array[j], array[j - h])) {
                    exch(array, j, j - h)
                    betterShow(array, j, j - h)
                    j -= h
                }
            }
            h /= 3
        }
        show(array)
    }

    companion object {
        @JvmStatic
        fun main(array: Array<String>) {
            val shell = Shell()
            shell.sort(shell.testArray())
        }
    }
}

