package dev.kodorebi.realmtypesafe.results

import dev.kodorebi.realmtypesafe.KProperties
import io.realm.RealmResults
import kotlin.reflect.KProperty1

fun <E, T : Number> RealmResults<E>.min(field: KProperty1<E, T?>) : T? {
    @Suppress("UNCHECKED_CAST")
    return this.min(field.name) as T?
}

fun <E, T : Number> RealmResults<E>.min(field: KProperties<E, T?>) : T? {
    @Suppress("UNCHECKED_CAST")
    return this.min(field.path) as T?
}