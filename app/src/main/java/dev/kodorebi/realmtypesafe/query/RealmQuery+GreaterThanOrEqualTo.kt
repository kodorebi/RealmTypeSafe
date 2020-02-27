package dev.kodorebi.realmtypesafe.query

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmQuery
import java.util.*
import kotlin.reflect.KProperty1

inline fun <E, reified T: Number> RealmQuery<E>.greaterThanOrEqualTo(field: KProperty1<E, T>, value: T) : RealmQuery<E> {
    val name = field.name

    return when (T::class) {
        Long::class -> this.greaterThanOrEqualTo(name, value.toLong())
        Double::class -> this.greaterThanOrEqualTo(name, value.toDouble())
        Float::class -> this.greaterThanOrEqualTo(name, value.toFloat())
        else -> this.greaterThanOrEqualTo(name, value.toInt())
    }
}

fun <E> RealmQuery<E>.greaterThanOrEqualTo(field: KProperty1<E, Date>, value: Date) : RealmQuery<E> {
    return this.greaterThanOrEqualTo(field.name, value)
}

inline fun <E, reified T: Number> RealmQuery<E>.greaterThanOrEqualTo(field: KProperties<E, T>, value: Number) : RealmQuery<E> {
    val name = field.path

    return when (T::class) {
        Long::class -> this.greaterThanOrEqualTo(name, value.toLong())
        Double::class -> this.greaterThanOrEqualTo(name, value.toDouble())
        Float::class -> this.greaterThanOrEqualTo(name, value.toFloat())
        else -> this.greaterThanOrEqualTo(name, value.toInt())
    }
}

fun <E> RealmQuery<E>.greaterThanOrEqualTo(field: KProperties<E, Date>, value: Date) : RealmQuery<E> {
    return this.greaterThanOrEqualTo(field.path, value)
}