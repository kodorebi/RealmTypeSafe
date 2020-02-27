package dev.kodorebi.realmtypesafe.query

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmQuery
import kotlin.reflect.KProperty1

fun <E, T : Number> RealmQuery<E>.max(field: KProperty1<E, T?>) : T? {
    @Suppress("UNCHECKED_CAST")
    return this.max(field.name) as T?
}

fun <E, T : Number> RealmQuery<E>.max(field: KProperties<E, T?>) : T? {
    @Suppress("UNCHECKED_CAST")
    return this.max(field.path) as T?
}