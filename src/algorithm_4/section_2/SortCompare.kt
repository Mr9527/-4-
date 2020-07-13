package algorithm_4.section_2

import edu.princeton.cs.introcs.StdOut
import edu.princeton.cs.introcs.StdRandom
import edu.princeton.cs.introcs.Stopwatch

class SortCompare {

    companion object {
        private fun time(alg: String, a: Array<Double>): Double {
            val timer = Stopwatch()
            when (alg) {
                "Selection" -> {
                    Selection.sort(a)
                }
                "Insertion" -> {
                    Insertion.sort(a)
                }
                "Shell" -> {
                    Shell.sort(a)
                }
                "Quick" -> {
                    Quick.sort(a)
                }
                "Heap" -> {
                    Heap.sort(a)
                }
                "Merge" -> {
                    Merge.sort(a)
                }
                "MergeBU" -> {
                    MergeBU.sort(a)
                }
                else -> NotImplementedError("not implement $alg")
            }
            return timer.elapsedTime()
        }

        private fun timeRandomInput(alg: String, N: Int, T: Int): Double {
            var total = 0.0
            val a = uniformArray(N)
            for (t in 0 until T) {
                for (i in 0 until N) {
                    a[i] = StdRandom.uniform()
                }
                total += time(alg, a)
            }
            return total
        }

        fun printArray(array: Array<*>) {
            println("---------------------")
            for (any in array) {
                print(any)
                print("  ")
            }
            println()
            println("---------------------")
        }

        fun match(sort1: String, sort2: String, n: Int, t: Int) {
            val time1 = timeRandomInput(sort1, n, t)
            val time2 = timeRandomInput(sort2, n, t)
            StdOut.printf("For %d random Doubles\n %s is ", n, sort1)
            StdOut.printf("%.1f times faster than %s\n", time2 / time1, sort2)
        }

        fun uniformArray(size: Int = 100) = Array(size) { StdRandom.uniform() }
        fun sameArray(size: Int = 100) = Array(size) { StdRandom.uniform() }

        @JvmStatic
        fun main(array: Array<String>) {
            val sort1 = "Shell"
//            val sort2 = "Insertion"
            val sort2 = "Insertion"
            val n = 200
            val t = 2
            val time1 = timeRandomInput(sort1, n, t)
            val time2 = timeRandomInput(sort2, n, t)
            StdOut.printf("For %d random Doubles\n %s is ", n, sort1)
            StdOut.printf("%.1f times faster than %s\n", time2 / time1, sort2)
            val toDouble = 0 * 1.0 / n
        }
    }
}