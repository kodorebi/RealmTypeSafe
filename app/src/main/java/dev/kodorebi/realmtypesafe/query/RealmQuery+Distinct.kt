package dev.kodorebi.realmtypesafe.query

import io.realm.RealmQuery
import kotlin.reflect.KProperty1

fun <E> RealmQuery<E>.distinct(field: KProperty1<E, *>) : RealmQuery<E> {
    return this.distinct(field.name)
}

fun <E> RealmQuery<E>.distinct(field: KProperty1<E, *>, vararg others: KProperty1<E, *>) : RealmQuery<E> {
    val otherFieldNames = others.map{it.name}.toTypedArray()
    return this.distinct(field.name, *otherFieldNames)
}