package algo.graphs

/**
 * Created by sHIVAM on 7/25/2017.
 */

sealed class EdgeType

class Directed() : EdgeType()
class Undirected(): EdgeType()

data class Edge<T: Comparable<T>>(var src:Vertex<T>, var dest:Vertex<T>, val weight:Double?)