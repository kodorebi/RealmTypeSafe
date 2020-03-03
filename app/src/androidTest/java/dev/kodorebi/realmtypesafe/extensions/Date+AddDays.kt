package dev.kodorebi.realmtypesafe.extensions

import java.util.*

fun Date.addDays(days: Int) : Date {
    val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
    calendar.time = this
    calendar.add(Calendar.DAY_OF_YEAR, days)
    return calendar.time
}