package algo

/**
 * Created by sHIVAM on 7/4/2017.
 */

fun twoSums(nums:List<Int>, target:Int) : List<Int> {
    for (i in 0..nums.count() - 1) {
        for (j in i + 1..nums.count() - 1) {
            if (nums[j] === target - nums[i]) {
                return listOf(i, j)
            }
        }
    }
    throw IllegalArgumentException("No Solution for given target")
}

/**
 * Following solution presents an O(n) time and O(n) space solution
 * **/

fun twoSums2(nums:List<Int>, target:Int): List<Int> {
    val map  = HashMap<Int, Int>()
    for (i in nums.indices) {
        val n2 = target - nums[i]
        if(map.containsKey(n2))
            return listOf(map[n2]?:-1, i)
        map.put(nums[i], i)
    }
    throw IllegalArgumentException("No solution for given target")
}

fun main(args: Array<String>) {
    val sol = twoSums2(listOf(2, 7, 11, 15), 9)
    println(sol)
}