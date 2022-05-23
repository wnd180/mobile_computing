import java.util.*

class MaxHeap(val A : Array<Int> ){
    var heapSize = 0

    fun left(i: Int): Int {
        return 2 * i
    }

    fun right(i: Int): Int {
        return 2 * i + 1
    }

    fun swap(A: kotlin.Array<Int>, i: Int, j: Int) {
        var temp = A[i]
        A[i] = A[j]
        A[j] = temp
    }

    fun max_heapify(A: kotlin.Array<Int>, i: Int) {
        var l = left(i);
        var r = right(i);
        var largest: Int;

        if ((l <= heapSize - 1) && (A[l] > A[i])) {
            largest = l;
        } else
            largest = i

        if ((r <= heapSize - 1) && (A[r] > A[l])) {
            largest = r
        }

        if (largest != i) {
            swap(A, i, largest);
            max_heapify(A, largest);
        }
    }

    fun MaxHeap(A: kotlin.Array<Int>) {
        heapSize = A.size
        for (i in heapSize / 2 downTo 0) {
            max_heapify(A, i)
        }
    }

    fun get_sorted_array(): Array<Int> {
        MaxHeap(A)
        for (i in A.size - 1 downTo 1) {
            swap(A, i, 0)
            heapSize = heapSize - 1
            max_heapify(A, 0)
        }
        A.reverse()
        return A
    }
}

var A = arrayOf(0,1,2,5,3,6,7,8,9,4)
var maxHeap = MaxHeap(A)
var sorted_array = maxHeap.get_sorted_array()
println(Arrays.toString(sorted_array))

