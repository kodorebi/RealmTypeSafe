package dev.kodorebi.realmtypesafe.query

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmQuery
import java.util.*
import kotlin.reflect.KProperty1


inline fun <E, reified T: Number> RealmQuery<E>.greaterThan(field: KProperty1<E, T>, value: T) : RealmQuery<E> {
    val name = field.name

    return when (T::class) {
        Long::class -> this.greaterThan(name, value.toLong())
        Double::class -> this.greaterThan(name, value.toDouble())
        Float::class -> this.greaterThan(name, value.toFloat())
        else -> this.greaterThan(name, value.toInt())
    }
}

fun <E> RealmQuery<E>.greaterThan(field: KProperty1<E, Date>, value: Date) : RealmQuery<E> {
    return this.greaterThan(field.name, value)
}


inline fun <E, reified T: Number> RealmQuery<E>.greaterThan(field: KProperties<E, T>, value: T) : RealmQuery<E> {
    val path = field.path

    return when (T::class) {
        Long::class -> this.greaterThan(path, value.toLong())
        Double::class -> this.greaterThan(path, value.toLong())
        Float::class -> this.greaterThan(path, value.toFloat())
        else -> this.greaterThan(path, value.toInt())
    }
}

fun <E> RealmQuery<E>.greaterThan(field: KProperties<E, Date>, value: Date) : RealmQuery<E> {
    return this.greaterThan(field.path, value)
}
