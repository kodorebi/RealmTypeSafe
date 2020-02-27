package dev.kodorebi.realmtypesafe.query

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmQuery
import java.util.*
import kotlin.reflect.KProperty1

fun <E, T : Number> RealmQuery<E>.between(field: KProperty1<E, T>, from: Int, to: Int) : RealmQuery<E> {
    return this.between(field.name, from, to)
}

fun <E, T : Number> RealmQuery<E>.between(field: KProperty1<E, T>, from: Long, to: Long) : RealmQuery<E> {
    return this.between(field.name, from, to)
}

fun <E, T : Number> RealmQuery<E>.between(field: KProperty1<E, T>, from: Double, to: Double) : RealmQuery<E> {
    return this.between(field.name, from, to)
}

fun <E, T : Number> RealmQuery<E>.between(field: KProperty1<E, T>, from: Float, to: Float) : RealmQuery<E> {
    return this.between(field.name, from, to)
}

fun <E> RealmQuery<E>.between(field: KProperty1<E, Date>, from: Date, to: Date) : RealmQuery<E> {
    return this.between(field.name, from, to)
}



fun <E, T : Number> RealmQuery<E>.between(field: KProperties<E, T>, from: Int, to: Int) : RealmQuery<E> {
    return this.between(field.path, from, to)
}

fun <E, T : Number> RealmQuery<E>.between(field: KProperties<E, T>, from: Long, to: Long) : RealmQuery<E> {
    return this.between(field.path, from, to)
}

fun <E, T : Number> RealmQuery<E>.between(field: KProperties<E, T>, from: Double, to: Double) : RealmQuery<E> {
    return this.between(field.path, from, to)
}

fun <E, T : Number> RealmQuery<E>.between(field: KProperties<E, T>, from: Float, to: Float) : RealmQuery<E> {
    return this.between(field.path, from, to)
}

fun <E> RealmQuery<E>.between(field: KProperties<E, Date>, from: Date, to: Date) : RealmQuery<E> {
    return this.between(field.path, from, to)
}


