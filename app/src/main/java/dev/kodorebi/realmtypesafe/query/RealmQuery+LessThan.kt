package dev.kodorebi.realmtypesafe.query

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmQuery
import java.util.*
import kotlin.reflect.KProperty1

inline fun <E, reified T: Number> RealmQuery<E>.lessThan(field: KProperty1<E, T>, value: T) : RealmQuery<E> {
    val name = field.name

    return when (T::class) {
        Long::class -> this.lessThan(name, value.toLong())
        Double::class -> this.lessThan(name, value.toDouble())
        Float::class -> this.lessThan(name, value.toFloat())
        else -> this.lessThan(name, value.toInt())
    }
}

fun <E> RealmQuery<E>.lessThan(field: KProperty1<E, Date>, value: Date) : RealmQuery<E> {
    return this.lessThan(field.name, value)
}



inline fun <E, reified T: Number> RealmQuery<E>.lessThan(field: KProperties<E, T>, value: Number) : RealmQuery<E> {
    val name = field.path

    return when (T::class) {
        Long::class -> this.lessThan(name, value.toLong())
        Double::class -> this.lessThan(name, value.toDouble())
        Float::class -> this.lessThan(name, value.toFloat())
        else -> this.lessThan(name, value.toInt())
    }
}

fun <E> RealmQuery<E>.lessThan(field: KProperties<E, Date>, value: Date) : RealmQuery<E> {
    return this.lessThan(field.path, value)
}