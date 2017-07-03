package algo

/**
 * Created by sHIVAM on 7/4/2017.
 */

fun <T:Comparable<T>> binarySearch(list:List<T>, key:T): Int? {
    require(list == list.sorted() || list == list.sortedDescending())
    var lo = 0
    var hi = list.count()
    while (lo < hi) {
        val mid = lo + (hi - lo)/2
        if(list[mid] == key)
            return mid
        else if(list[mid] < key)
            lo = mid + 1
        else
            hi = mid
    }

    return null
}
