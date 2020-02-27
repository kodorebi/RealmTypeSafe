package dev.kodorebi.realmtypesafe.query

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmQuery
import java.util.*
import kotlin.reflect.KProperty1

inline fun <E, reified T: Number> RealmQuery<E>.lessThanOrEqualTo(field: KProperty1<E, T>, value: Number) : RealmQuery<E> {
    val name = field.name

    return when (T::class) {
        Long::class -> this.lessThanOrEqualTo(name, value.toLong())
        Double::class -> this.lessThanOrEqualTo(name, value.toDouble())
        Float::class -> this.lessThanOrEqualTo(name, value.toFloat())
        else -> this.lessThanOrEqualTo(name, value.toInt())
    }
}

fun <E> RealmQuery<E>.lessThanOrEqualTo(field: KProperty1<E, Date>, value: Date) : RealmQuery<E> {
    return this.lessThanOrEqualTo(field.name, value)
}


inline fun <E, reified T: Number> RealmQuery<E>.lessThanOrEqualTo(field: KProperties<E, T>, value: Number) : RealmQuery<E> {
    val name = field.path

    return when (T::class) {
        Long::class -> this.lessThanOrEqualTo(name, value.toLong())
        Double::class -> this.lessThanOrEqualTo(name, value.toDouble())
        Float::class -> this.lessThanOrEqualTo(name, value.toFloat())
        else -> this.lessThanOrEqualTo(name, value.toInt())
    }
}

fun <E> RealmQuery<E>.lessThanOrEqualTo(field: KProperties<E, Date>, value: Date) : RealmQuery<E> {
    return this.lessThanOrEqualTo(field.path, value)
}