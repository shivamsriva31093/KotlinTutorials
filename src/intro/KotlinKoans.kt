package intro

import java.util.*

/**
 * Created by sHIVAM on 5/31/2017.
 *
 * Read about operator overloading to learn how different conventions for operations
 * like ==, <, + work in Kotlin. Add the function compareTo to the class MyDate to
 * make it comparable. After that the code below date1 < date2 will start to compile.

    In Kotlin when you override a member, the modifier override is mandatory.
 */

//data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
//
//    override fun compareTo(other: MyDate): Int = when {
//        year != other.year -> year - other.year
//        month != other.month -> month - other.month
//        else -> dayOfMonth - other.dayOfMonth
//    }
//}
//
//fun compare(date1: MyDate, date2: MyDate) = date1 < date2


/**
 * In Kotlin in checks are translated to the corresponding contains calls:
 *
 *       val list = listOf("a", "b")
 *      "a" in list  // list.contains("a")
 *       "a" !in list // !list.contains("a")
 *   Read about ranges. Add a method fun contains(d: MyDate) to the class DateRange
 *  to allow in checks with a range of dates.
 * */

//class DateRange(val start: MyDate, val endInclusive: MyDate) {
//    operator fun contains(d : MyDate):Boolean {
//        return d in start..endInclusive
//    }
//}
//
//fun checkInRange(date: MyDate, first: MyDate, last: MyDate): Boolean {
//    return date in DateRange(first, last)
//}


/**
 * Implement the function MyDate.rangeTo(). This allows you to create a range of dates using the following syntax:
 * MyDate(2015, 5, 11)..MyDate(2015, 5, 12)
 * Note that now the class DateRange implements the standard ClosedRange interface
 * and inherits contains method implementation.
 *
 * **/

//operator fun MyDate.rangeTo(other: MyDate) = DateRange(this, other)
//
//class DateRange(override val start: MyDate, override val endInclusive: MyDate): ClosedRange<MyDate>

//fun checkInRange(date: MyDate, first: MyDate, last: MyDate): Boolean {
//    return date in first..last
//}

/**
 * Kotlin for loop iterates through anything that provides an iterator.
 * Make the class DateRange implement Iterable<MyDate>, so that it could be iterated over.
 * You can use the function MyDate.nextDay() defined in DateUtil.kt
 *
 * */


//operator fun MyDate.rangeTo(other: MyDate) = DateRange(this, other)
//
//class DateRange(val start: MyDate, val end: MyDate): Iterable<MyDate> {
//    override fun iterator(): Iterator<MyDate> = DateIterator(this)
//
//}
//
//class DateIterator(val dateRange: DateRange) : Iterator<MyDate> {
//    var current:MyDate = dateRange.start
//
//    override fun hasNext(): Boolean {
//        return  current<= dateRange.end
//    }
//
//    override fun next(): MyDate {
//        val res = current
//        current = current.nextDay()
//        return res
//    }
//
//}
//
//
//fun MyDate.nextDay() = addTimeIntervals(TimeInterval.DAY, 1)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

fun MyDate.addTimeIntervals(timeInterval: TimeInterval, number: Int): MyDate {
    val c = Calendar.getInstance()
    c.set(year + if (timeInterval == TimeInterval.YEAR) number else 0, month, dayOfMonth)
    var timeInMillis = c.timeInMillis
    val millisecondsInADay = 24 * 60 * 60 * 1000L
    timeInMillis += number * when (timeInterval) {
        TimeInterval.DAY -> millisecondsInADay
        TimeInterval.WEEK -> 7 * millisecondsInADay
        TimeInterval.YEAR -> 0L
    }
    val result = Calendar.getInstance()
    result.timeInMillis = timeInMillis
    return MyDate(result.get(Calendar.YEAR), result.get(Calendar.MONTH), result.get(Calendar.DATE))
}


/**
 * Implement a kind of date arithmetic. Support adding years, weeks and days to a date.
 * You could be able to write the code like this: date + YEAR * 2 + WEEK * 3 + DAY * 15.
 * At first, add an extension function 'plus()' to MyDate, taking a TimeInterval as an argument.
 * Use an utility function MyDate.addTimeIntervals().Then, try to support adding several time intervals to a date.
 * You may need an extra class.
 *
 * */


data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)


operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = addTimeIntervals(timeInterval, 1)

data class nTimeIntervals(val timeInterval: TimeInterval, val number: Int)

operator fun TimeInterval.times(number: Int) = nTimeIntervals(this, number)

operator  fun MyDate.plus(timeIntervals: nTimeIntervals) = addTimeIntervals(timeIntervals.timeInterval, timeIntervals.number)

fun task1(today: MyDate): MyDate {
    return today + TimeInterval.YEAR + TimeInterval.WEEK
}

fun task2(today: MyDate): MyDate {
    TODO("Uncomment") //return today + YEAR * 2 + WEEK * 3 + DAY * 5
}