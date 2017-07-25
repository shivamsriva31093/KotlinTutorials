package algo.graphs

/**
 * Created by sHIVAM on 7/25/2017.
 */

data class Vertex<T: Comparable<T>>(val data: T) {
    override fun toString(): String {
        return "$data"
    }
}