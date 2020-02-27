package dev.kodorebi.realmtypesafe.query

import io.realm.RealmQuery
import kotlin.reflect.KProperty1

fun <E, T: Number> RealmQuery<E>.sum(field: KProperty1<E, T?>) : Number {
    return this.sum(field.name)
}