package algo.graphs

/**
 * Created by sHIVAM on 7/25/2017.
 */

interface Graphable<T: Comparable<T>> {
    fun newVertex(data : T) : Vertex<T>
    fun add(type: EdgeType, source: Vertex<T>, dest: Vertex<T>, weight:Double? = 0.0)
    fun weight(src: Vertex<T>, dest: Vertex<T>) : Double?
    fun edges(src: Vertex<T>): MutableList<Edge<T>>?
}